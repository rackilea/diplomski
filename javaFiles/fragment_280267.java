File storageDir = new File(Environment.getExternalStorageDirectory() + "/", "MyImages");

            if (!storageDir.exists()) {
                storageDir.mkdirs();//directory created
            }
            // get the current timestamp
            String timest = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());
//Create your picture file
 File pictureFile;
 pictureFile = new File(storageDir.getPath()+File.separator+ "IMG_" + timeStamp + ".jpg");