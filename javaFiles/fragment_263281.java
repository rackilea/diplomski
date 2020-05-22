try {
        in = new FileInputStream("./TestDir/IOfile.txt");
        out = new FileOutputStream("./TestDir/IOfile_out.txt");

        byte[] buffer = new byte[100];
        // more operations
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }finally{
        try {
            if(in!=null && out!= null) {
                in.close();
                out.close();
            }
        }catch (IOException io){
            io.printStackTrace();
        }
    }