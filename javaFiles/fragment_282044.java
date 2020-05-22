private File getFile() {


      File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "My_folder");

        if(!folder.exists()) {
            folder.mkdir();
        }

        File image_file = new File(folder, "cam_image.lpg");

        return image_file;
    }