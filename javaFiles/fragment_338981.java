public static void main(String[] args){

    final int BUFFERSIZE = 1024 << 8;
    File baseDir = new File("C:\\path\\logs\\");

    // Get the simple names of the files ("foo.log" not "/path/logs/foo.log")
    String[] fileNames = baseDir.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".log");
        }
    });

    // Sort the names
    Arrays.sort(fileNames);

    // Create the output file
    File output = new File(baseDir.getAbsolutePath() + File.separatorChar + "MERGED.log");
    try{
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output), BUFFERSIZE);
        byte[] bytes = new byte[BUFFERSIZE];
        int bytesRead;
        final byte[] newLine = "\n".getBytes(); // use to separate contents

        for(String s : fileNames){
            // get the full path to read from
            String fullName = baseDir.getAbsolutePath() + File.separatorChar + s;
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fullName),BUFFERSIZE);
            while((bytesRead = in.read(bytes,0,bytes.length)) != -1){
                out.write(bytes, 0, bytesRead);
            }
            // close input file and ignore any issue with closing it
            try{in.close();}catch(IOException e){}
            out.write(newLine); // seperation
        }

        out.close();
    }catch(Exception e){
        throw new RuntimeException(e);
    }
}