public static void main(String[] args) {
        FileSystemManager fsManager = null;
        String path = "\\\\myip\\storage\\ogg\\VX-276.ogg";
        try {
             fsManager = VFS.getManager();

        FileObject basePath;


            basePath = fsManager.resolveFile("file:" + path);




            if (basePath.exists())
                System.out.println("exists");
            else {
                System.out.println("missing" + basePath.getURL());
            }
        } catch (FileSystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }