private void createFile(byte[] fileData) {
            try {
                //Create directory..
                File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/YOUR_FOLDER_NAME");
                File dir = new File(root + File.separator);
                if (!dir.exists()) dir.mkdir();

                //Create file..
                File file = new File(root + File.separator + "YOUR_IMAGE_NAME");
                file.createNewFile();

                FileOutputStream out = new FileOutputStream(file);
                out.write(fileData);
                out.close();

            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }