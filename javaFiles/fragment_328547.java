try {
    FileInputStream fin = new FileInputStream(fileToRead); // open this file

    }
catch(FileNotFoundException exc) {
    System.out.println("File Not Found");
    }

try{
    FileInputStream fin = new FileInputStream(fileToRead);
    fin.close(); // close the file
    }
catch(IOException exc) {
    System.out.println("Error Closing File");
    }