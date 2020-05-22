Path movefrom = FileSystems.getDefault().getPath(selectedFile.getPath());
            Path target = FileSystems.getDefault().getPath("userfiles/"+UNAME+"/"+ANAME+"/"+selectedFile.getName());
            Path targetDir = FileSystems.getDefault().getPath("userfiles/"+UNAME+"/"+ANAME);
            try{
                Files.move(movefrom,target,StandardCopyOption.ATOMIC_MOVE);
            }catch (IOException e){}