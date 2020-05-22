String source = "resources/inputfile.txt";
    BufferedReader fin;

    InputStream inputStream = getClass().getResourceAsStream(source.substring(source.lastIndexOf("/")));
    if (inputStream != null) {
        fin = new BufferedReader(new InputStreamReader(inputStream));
    } else {
        fin = new BufferedReader(new FileReader(new File(source)));
    }