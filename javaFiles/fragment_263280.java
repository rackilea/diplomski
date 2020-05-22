try {
        FileInputStream in = new FileInputStream("./TestDir/IOfile.txt");
        FileOutputStream out = new FileOutputStream("./TestDir/IOfile_out.txt");

        byte[] buffer = new byte[100];
        // more operations
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }