public void writeFile(String value){
    String PATH = "/remote/dir/server/";
    String directoryName = PATH.concat(this.getClassName());
    String fileName = id + getTimeStamp() + ".txt";

    File directory = new File(directoryName);
    if (! directory.exists()){
        directory.mkdir();
        // If you require it to make the entire directory path including parents,
        // use directory.mkdirs(); here instead.
    }

    File file = new File(directoryName + "/" + fileName);
    try{
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(value);
        bw.close();
    }
    catch (IOException e){
        e.printStackTrace();
        System.exit(-1);
    }
}