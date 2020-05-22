File f = new File(FILE_DIR + fileName);

        if(f.exists()) { 

            System.out.print("file already exists");

            fileName = "copy_of_ " + X + fileName;
x++;

        }