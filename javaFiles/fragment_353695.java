InputStream is = getAssets().open(imageName.getText().toString());
int size = is.available();
byte[] buffer = new byte[size];
is.read(buffer);
is.close();
String path = Environment.getExternalStorageDirectory()+"/" + APP_NAME()+"/pictures/"+ls+"/" ;
new File(path).mkdirs();
String fileName = System.currentTimeMillis() + imageName.getText().toString().replace("pic/" , "");
FileOutputStream fileOutputStream = new FileOutputStream(new File(path+fileName));
fileOutputStream.write(buffer);
fileOutputStream.close();
//InputStream inputStream = new FileInputStream(new File(path+fileName));

//String bitmapPath = MediaStore.Images.Media.insertImage(getContentResolver(),b(inputStream) ,"title", null); // comment this line
Uri bitmapUri = Uri.parse(new File(path+fileName).toString()); //changed

Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("image/*");
intent.putExtra(Intent.EXTRA_STREAM , bitmapUri);
startActivity(intent);

if (new File(path+fileName).exists()){
    new File(path+fileName).delete();
}