public void close() {
    boolean loadFromClasspath = true;
    String fileName = "..."; // provide an absolute path here to be sure that file is found
    BufferedReader reader = null;
    try {

        if (loadFromClasspath) {
            // loading from classpath
            // see the link above for more options
            InputStream in = getClass().getClassLoader().getResourceAsStream("absolute/path/to/file/inside/jar/lol.txt"); 
            reader = new BufferedReader(new InputStreamReader(in));
        } else {
            // load from file system
            reader = new BufferedReader(new FileReader(new File(fileName)));
        }

        String line = null;
        while ( (line = reader.readLine()) != null) {
            // do something with the line here
            System.out.println("Line read: " + line);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null,e.getMessage()+" for lol.txt","File Error",JOptionPane.ERROR_MESSAGE);
    } finally {
        if (reader != null) {
            reader.close();  
        }
    }
}