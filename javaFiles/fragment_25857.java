public static BufferedReader getFileBufferedReader(String fileName) throws FileNotFoundException, IOException{
    File file = new File(fileName);
    if (!file.exists()) {  
        OutputStream out = new FileOutputStream(file);
        out.close();
    }
    FileReader fr = new FileReader(file);
    return new BufferedReader(fr);
}