//1.Fill the data from db

  //2.Set the response properties
  String fileName = "Excel.xls";
  response.setHeader("Content-Disposition", "inline; filename=" + fileName);
  // Make sure to set the correct content type(the below content type is ok)
  response.setContentType("application/vnd.ms-excel");

  //3.Write to the output stream
  Writer.write();//call write method of Writer class to write the data to o/p stream