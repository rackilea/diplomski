static BufferedReader getBufferedReader(String path) {
    try{
        FileReader fr = new FileReader(path);
        return new BufferedReader(fr);
    }
    catch(IOException ex) {
        // handle somehow
    }
}