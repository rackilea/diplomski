FileInputStream inputStream = new FileInputStream("FileInputStreamDemo.java");  //read the file

    response.setHeader("Content-Disposition","attachment; filename=test.txt");
    try {
        int c;
        while ((c = inputStream.read()) != -1) {
        response.getWriter().write(c);
        }
    } finally {
        if (inputStream != null) 
            inputStream.close();
            response.getWriter().close();
    }