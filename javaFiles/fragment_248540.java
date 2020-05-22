if (f.exists() && !f.isDirectory()){
        System.out.println("Yes, File does exist");
        try {
            FileInputStream fis = new FileInputStream(f);
            //perform operation on the file
            System.out.println(f.getAbsolutePath()); 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } else {
        System.out.println("File does not exist");
    }