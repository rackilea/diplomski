String user = System.getProperty("user.name");
        //Assuming your download location is the default location
        File f = new File("C:/users/" + user + "/Downloads/NameOfYourDownloadedFile.fileType");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("File downloaded successfully...");
            /*If you have to run the test multiple times,
            you may want to delete the file once it's downloaded so*/ 
            if (f.delete()) {
                System.out.println("File Removed...");
            } else {
                System.out.println("Failed to delete the file...");
            }
        } else {
            System.out.println("The file was not downloaded...");

        }