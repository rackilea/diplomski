...
    String idRiparazione = null;
    String idMandrinoSmontato = null;
    String serviceLivello = null;

    try {
        List formItems = upload.parseRequest(request);
        Iterator it = formItems.iterator();
        // iterates over form's fields
        while(it.hasNext()) {
            FileItem item = (FileItem) it.next();
            // processes only fields that are not form fields
            if (!item.isFormField()) {
                String fileName = new File(item.getName()).getName();
                String filePath = uploadPath + File.separator + fileName;
                File storeFile = new File(filePath);
                // saves the file on disk
                item.write(storeFile);
            }
            else
            {
                if ("idRiparazione".equals(item.getFieldName()))
                    idRiparazione = item.getString();
                else if ("idMandrinoSmontato".equals(item.getFieldName()))
                    idMandrinoSmontato = item.getString();
                else if ("serviceLivello".equals(item.getFieldName()))
                    serviceLivello = item.getString();
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello Servlet Get</h1>");
        out.println(idMandrinoSmontato);
        out.println(serviceLivello);
        out.println("</body>");
        out.println("</html>");             
    } catch (FileUploadException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }