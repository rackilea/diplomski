PrintWriter out = response.getWriter();
       System.out.println("Request content length is " + request.getContentLength() + "<br/>"); 
       System.out.println("Request content type is " + request.getHeader("Content-Type") + "<br/>");
       boolean isMultipart = ServletFileUpload.isMultipartContent(request);
       if(isMultipart){
                  ServletFileUpload upload = new ServletFileUpload();
           try{
               FileItemIterator iter = upload.getItemIterator(request);
               FileItemStream item = null;
               String name = "";
               InputStream stream = null;
               while (iter.hasNext()){
                                     item = iter.next();
                                     name = item.getFieldName();
                                     stream = item.openStream();
                  if(item.isFormField()){System.out.println("Form field " + name + ": " 
                                           + Streams.asString(stream) + "<br/>");}
                  else {
                      name = item.getName();
                      System.out.println("name==" + name);
                      if(name != null && !"".equals(name)){
                         String fileName = new File(item.getName()).getName();
                         out.write("Client file: " + item.getName() + " <br/>with file name "
                                                    + fileName + " was uploaded.<br/>");
                         File file = new File(getServletContext().getRealPath("/WEB-INF/temp/" + fileName));
                         FileOutputStream fos = new FileOutputStream(file);
                         long fileSize = Streams.copy(stream, fos, true);
                         System.out.println("Size was " + fileSize + " bytes <br/>");
                         System.out.println("File Path is " + file.getPath() + "<br/>");
                      }
                  }
               }
           } catch(FileUploadException fue) {out.write("fue!!!!!!!!!");}
       }