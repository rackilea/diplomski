protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub



          String filename = request.getParameter("file").toString();   
          String filepath = request.getParameter("path").toString();  

         File f = new File (filepath + filename);
         //set the content type(can be excel/word/powerpoint etc..)

         String type = request.getParameter("type");
         response.setContentType (type);

         //set the header and also the Name by which user will be prompted to save
         response.setHeader ("Content-Disposition", "attachment; filename=\""+filename+"\"");

         //get the file name
         String name = f.getName().substring(f.getName().lastIndexOf("/") + 1, f.getName().length());

         //OPen an input stream to the file and post the file contents thru the 
         //servlet output stream to the client m/c
          InputStream in = new FileInputStream(f);

        try{
              ServletOutputStream outs = response.getOutputStream();

              int bytesRead;
              byte[] buf = new byte[4 * 1024]; // 4K buffer

              try {
                   while ((bytesRead = in.read(buf)) != -1){ 
                       outs.write(buf, 0, bytesRead);
                   }

              } catch (IOException ioe) {
                  ioe.printStackTrace(System.out);
              }


              outs.flush();
              outs.close();
              in.close(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }