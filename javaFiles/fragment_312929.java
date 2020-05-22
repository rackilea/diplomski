public static String convertXMLToString(File pCurrentXML) {

        InputStream is = null;
        try {
            is = new FileInputStream(pCurrentXML);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        String contents = null;
         try {

                try {
                    contents = IOUtils.toString(is, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                IOUtils.closeQuietly(is);
            }

        return contents;

    }