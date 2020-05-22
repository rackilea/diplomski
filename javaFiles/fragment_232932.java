String sfilename="report";
    String path = "appname/" + sfilename + ".jasper";
    String imgp=("images");

    InputStream reportName = this.getClass().getClassLoader().getResourceAsStream(path);

    HashMap param = new HashMap();
    param.put("param1","value1");
    param.put("param2","value2");
    param.put("imgpath",imgp); 
    param.put("SUBREPORT_DIR", "appname/"); 

    try {   
        JasperPrint jp = JasperFillManager.fillReport(reportName, param, conn);

        net.sf.jasperreports.swing.JRViewer jv = new net.sf.jasperreports.swing.JRViewer(jp);

 //Insert viewer to a JFrame to make it showable
        JFrame jf = new JFrame();
        jf.getContentPane().add(jv);
        jf.validate();
        jf.setVisible(true);
        jf.setSize(new Dimension(800,600));
        jf.setLocation(300,100);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setTitle("JASPER REPORT");