try {
     ServletFileUpload upload = new ServletFileUpload();
     FileItemIterator iter = upload.getItemIterator(request);

     while (iter.hasNext()) {
          FileItemStream item = iter.next();
          String name = item.getFieldName();

          if (item.isFormField()) {
               String value = Streams.asString(item.openStream());
          }
     }          
 } catch (Exception ex) {}