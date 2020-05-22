File file = new File("Path Where you want to write your excel file");
  response.setContentType("application/vnd.ms-excel"); 
  response.addHeader("Content-Disposition", "attachment; filename=" + "Excel_Report_Name.xls");
  response.setContentLength((int) file.length());
  FileInputStream fileInputStream = new FileInputStream(file);
    try{
         OutputStream responseOutputStream = response.getOutputStream();
         int bytes;
         while ((bytes = fileInputStream.read()) != -1) {
         responseOutputStream.write(bytes);
     }
     responseOutputStream.close();

    }catch(Exception e){
         e.printStackTrace();
         System.err.println("Inside Try/catch");