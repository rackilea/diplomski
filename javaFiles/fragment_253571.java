public static void writeSaves(File src, File dest) throws IOException { 
    if(src.isDirectory()){
        //if directory not exists, create it
        if(!dest.exists()){
           dest.mkdirs();
        }

        //list all the directory contents
        String files[] = src.list();

        for (String file : files) {
           //construct the src and dest file structure
           File srcFile = new File(src, file);
           File destFile = new File(dest, file);
           //recursive copy
           writeSaves(srcFile,destFile);
        }

    }else{
        //if file, then copy it
        //Use bytes stream to support all file types

        InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes
            while ((length = in.read(buffer)) > 0){
               out.write(buffer, 0, length);
            }

            in.close();
            out.close();
    }