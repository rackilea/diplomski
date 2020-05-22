public int countThem(File file) throws FileNotFoundException, IOException{
    int count = 0;
    File []files = file.listFiles();

    for(File f : files){
        if(f.isDirectory()) {
            count += countThem(f);
        } else {
            if(f.getName().startsWith("D")) {
                count++;
            }
        }
    }

    return count;
}