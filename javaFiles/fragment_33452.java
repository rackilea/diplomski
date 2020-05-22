public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        String result = "";
        InputStreamReader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");        
        char[] buffer = new char[len];
        while(reader.read(buffer) >= 0)
        {
            result = result + (new String(buffer));
            buffer = new char[len];
        }
        return result;
    }