File file = getDir("custom", MODE_PRIVATE);
        String path = file.getAbsolutePath();
        File create_dir = new File(path+"/dir_name");
        if(!create_dir.exists()){
            create_dir.mkdir();
        }