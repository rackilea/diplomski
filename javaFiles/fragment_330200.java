<%
Connection conn = null;
Object o2 = session.getAttribute("email");
String email = o2.toString();
String category=(String)session.getAttribute("category");
String status=(String)session.getAttribute("status");
String startDate=(String)session.getAttribute("startDate");
String endDate=(String)session.getAttribute("endDate");

try 
{
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketing_database","root","root");
    String sql = "select * from lead where Email = '" + email + "' AND Status LIKE '%" + status + "%' AND Category LIKE '%" + category + "%' AND STR_TO_DATE(`Lead_Date`, '%d-%m-%Y') BETWEEN '"+startDate+"' AND '"+endDate+"'";
    ServletContext context = request.getServletContext(); 
    String fullPath = context.getRealPath("/WEB-INF/reports/report10.jrxml");
    InputStream input = new FileInputStream(new File(fullPath));
    JasperDesign jasperDesign = JRXmlLoader.load(input);

    System.out.println("Compiling Report Designs");
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

    System.out.println("Creating JasperPrint Object");
    HashMap<String,Object> map = new HashMap<String,Object>();
    map.put("sql",sql);
            byte[] bytes = JasperRunManager.runReportToPdf(jasperReport, map, conn);

            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
            conn.close();
}
catch(Exception e) 
{e.printStackTrace();} 

        %>