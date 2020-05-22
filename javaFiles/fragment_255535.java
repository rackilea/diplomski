public @ResponseBody Object getFileV1(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=Test Report " + new Date().toString()  + ".zip");
            String stringValue1 = "This is a test value for csv1";
            String stringValue2 = "This is a test value for csv2";

            PrintWriter writer1 = new PrintWriter(new OutputStreamWriter(new FileOutputStream("stringValue1.csv"), "UTF-8"));
            writer1.print(stringValue1);
            writer1.close();

            PrintWriter writer2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream("stringValue2.csv"), "UTF-8"));
            writer2.print(stringValue2);
            writer2.close();


            File file1 = new File("stringValue1.csv");
            File file2 = new File("stringValue2.csv");
            filesToZip(response, file1, file2);     

            file1.delete();
            file2.delete();

            response.flushBuffer();
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }