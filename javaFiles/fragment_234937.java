else if (file.isDirectory()){
            File nf = new File(file.getAbsolutePath()+File.separator+"newFile")     
            nf.createNewFile();
            System.out.println("Subdirectory :" +file.getName());   

        }