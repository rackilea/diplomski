FileWriter myFileWriter = null;
    File myFile = new File("myFile.txt");
    try {
        // file is created on the file-system here
        myFileWriter = new FileWriter(myFile);

        myFileWriter.write("hello");
    } finally {
        if (myFileWriter != null) {
            myFileWriter.close();
        }
    }