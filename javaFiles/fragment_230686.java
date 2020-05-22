private static final String reportsPath = "someplace/nice/";
private ArrayList<String>   completedSubReports = new ArrayList<String>(30);
private Throwable           subReportException  = null;

/**
 * Recursively compile report and subreports
 */
public JasperReport compileReport(String reportName) throws Throwable{
  JasperDesign jasperDesign = JRXmlLoader.load(reportsPath + reportName + ".jrxml");
  JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
  JRSaver.saveObject(jasperReport, reportsPath + reportName + ".jasper");
  toLog("Saving compiled report to: " + reportsPath + reportName + ".jasper");
  //Compile sub reports
  JRElementsVisitor.visitReport(jasperReport, new JRVisitor(){
    @Override
    public void visitBreak(JRBreak breakElement){}

    @Override
    public void visitChart(JRChart chart){}

    @Override
    public void visitCrosstab(JRCrosstab crosstab){}

    @Override
    public void visitElementGroup(JRElementGroup elementGroup){}

    @Override
    public void visitEllipse(JREllipse ellipse){}

    @Override
    public void visitFrame(JRFrame frame){}

    @Override
    public void visitImage(JRImage image){}

    @Override
    public void visitLine(JRLine line){}

    @Override
    public void visitRectangle(JRRectangle rectangle){}

    @Override
    public void visitStaticText(JRStaticText staticText){}

    @Override
    public void visitSubreport(JRSubreport subreport){
      try{
        String expression = subreport.getExpression().getText().replace(".jasper", "");
        StringTokenizer st = new StringTokenizer(expression, "\"/");
        String subReportName = null;
        while(st.hasMoreTokens())
          subReportName = st.nextToken();
        //Sometimes the same subreport can be used multiple times, but
        //there is no need to compile multiple times
        if(completedSubReports.contains(subReportName)) return;
        completedSubReports.add(subReportName);
        compileReport(subReportName);
      }
      catch(Throwable e){
        subReportException = e;
      }
    }
    @Override
    public void visitTextField(JRTextField textField){}

    @Override
    public void visitComponentElement(JRComponentElement componentElement){}

    @Override
    public void visitGenericElement(JRGenericElement element){}
  });
  if(subReportException != null) throw new RuntimeException(subReportException);
  return jasperReport;
}