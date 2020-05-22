try{
        //This is for downloading
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=nameOfExcel");    
        File file = new File("path_to_the_file/excelfile.xls"); //<- the name of excel that you have already created.
        FileInputStream fileIn = new FileInputStream(file);
        ServletOutputStream out = response.getOutputStream();

        byte[] outputByte = new byte[4096];
        //copy binary contect to output stream
        while(fileIn.read(outputByte, 0, 4096) != -1)
        {
                out.write(outputByte, 0, 4096);
        }
        fileIn.close();
        out.flush();
        out.close();
  }
  catch(IOException e){
        e.printStackTrace();
  }