public Bitmap readBitmapFromMemory(String filename) {
Bitmap defautBitmap = null;
File filePath = this.getFileStreamPath(filename);
FileInputStream fi;
try {
fi = new FileInputStream(filePath);
defautBitmap = BitmapFactory.decodeStream(fi);

} 
catch (FileNotFoundException e) {
e.printStackTrace();

}

return defautBitmap;

}