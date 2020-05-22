String filePath = null;
    try {
        //Encoding filename to UTF-8, doesn't support folders with UTF-8 characters
        filePath = song.getParentFile().toURI().toString()
                + URLEncoder.encode(song.getName(), "UTF-8").replace("+", "%20");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }
Media media = new Media(filePath);