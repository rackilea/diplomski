public String getStringFromInputStream(InputStream is) {

        InputStreamReader in = new InputStreamReader(is);
        String str = "";

        try {
            while (in.ready()) {
                str = str + (char) in.read();  
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }