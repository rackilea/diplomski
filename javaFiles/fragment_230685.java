JRElementsVisitor.visitReport(jasperReport, new JRVisitor(){

  // ** snip other overrides **

  @Override
  public void visitSubreport(JRSubreport subreport){
    String expression = subreport.getExpression().getText().replace(".jasper", ".jrxml");
    StringTokenizer st = new StringTokenizer(expression, "\"/");
    String subreportName = null;
    while(st.hasMoreTokens())
      subreportName = st.nextToken();
    compileReport(subreportName);
  }
}