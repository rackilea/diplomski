File file=new File(fname);
FileInputStream fis=new FileInputStream(file);

        response.setHeader("Content-Length", String.valueOf(file.length()));
            response.setHeader("Content-Disposition",
                             "attachment;filename="+fname+".xlsm");
            ServletContext ctx = getServletContext();
            InputStream input = new BufferedInputStream(new FileInputStream(file), 1024 * 10);
            OutputStream output = new BufferedOutputStream(response.getOutputStream(), 1024 * 10);

            byte[] buffer = new byte[1024 * 10];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        output.flush();
        output.close();
        input.close();
        fis.close();