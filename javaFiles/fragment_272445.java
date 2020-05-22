public String loadTextFromFile() {
        String sText = null;
        try {
            //If your file is in assets folder
            InputStream is = getAssets().open("file_name.txt");
            //If your file is in raw folder
            InputStream is = getResources().openRawResource(R.raw.file_name);
            //Use one of the above as per your file existing folder

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            sText = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return sText;
    }