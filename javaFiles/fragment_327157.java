File sdCard = Environment.getExternalStorageDirectory();
File dir = new File (sdCard.getAbsolutePath() + "/dir1/dir2");
dir.mkdirs();
File file = new File(dir, "filename");

FileOutputStream f = new FileOutputStream(file);
...