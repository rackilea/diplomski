public void generateReport() {
  Connection con
  try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sentiment","root", "abcd");
    System.out.println("Compiling report...");
    JasperReport jasperReport = JasperCompileManager.compileReport("/home/abcd/report/R_D1.jrxml");
    System.out.println("Filling report...");
    JasperFillManager.fillReportToFile(jasperReport,new HashMap<String, Object> (), con);
    System.out.println("Done!");
  } catch (JRException e) {
    e.printStackTrace();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  } catch (SQLException e) {
    e.printStackTrace();
  } finally {
    if (con != null){
      con.close();
    }
  }
}