String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Trainer app/";

File dictionary = new File(path);
if (!dictionary.exists()) {
   dictionary.mkdirs();
}