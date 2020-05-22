private String readPath(BufferedReader bufferedReader) throws IOException {
    boolean ok = false;
    do {
        System.out.println("Please enter a Path:");
        File f = new File(bufferedReader.readLine());
        if(f.exists() && f.isDirectory())
            ok = true;
        else
            System.err.println("Doesn't exist or is not a folder.");
    } while(!ok);
    return f.getAbsolutePath();
}