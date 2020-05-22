<body>
<% 
Connection conn = null;

try 
{ 
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketing_database","root","root");
    String jrxmlFile ="D:/dev/tools/jasper files/report10.jrxml";
    InputStream input = new FileInputStream(new File(jrxmlFile));
    JasperDesign jasperDesign = JRXmlLoader.load(input);

    System.out.println("Compiling Report Designs");
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

    System.out.println("Creating JasperPrint Object");
    Map parameters = new HashMap();
    parameters.put("category",session.getAttribute("cat"));
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,conn);
    byte bytes[] = new byte[10000]; 
    JRPdfExporter exporter = new JRPdfExporter();
    ByteArrayOutputStream PDFStream = new ByteArrayOutputStream(); 
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, PDFStream); 
    exporter.exportReport(); 
    System.out.println("Size of byte array:"+PDFStream.size()); 
    bytes = PDFStream.toByteArray(); 
    response.setContentType("application/pdf"); 
    System.out.println("After JasperPrint = 1"); 
    response.setContentLength(bytes.length); 
    System.out.println("After JasperPrint = 2"); 
    PDFStream.close(); 
    System.out.println("After JasperPrint = 3"); 

    OutputStream outputStream = response.getOutputStream(); 
    System.out.println("After JasperPrint = 4"); 
    outputStream.write(bytes, 0, bytes.length); 
    outputStream.flush(); 
    outputStream.close(); 

}
catch(Exception e) 
{e.printStackTrace();} 

%>
</body>