private void loadImageFromStorage(String path){
    try {
        File f=new File(path, "profile.jpg");
        Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.imgPicker);
        img.setImageBitmap(b);
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}