try {
     // get uri from Intent
     Uri uri = data.getData();
     // get bitmap from uri
     Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
     // store bitmap to file
     File filename = new File(Environment.getExternalStorageDirectory(), "imageName.jpg");
     FileOutputStream out = new FileOutputStream(filename);
     bitmap.compress(Bitmap.CompressFormat.JPEG, 60, out);
     out.flush();
     out.close();
     // get base64 string from file
     String base64 = getStringImage(filename);
     // use base64 for your next step.
} catch (IOException e) {
     e.printStackTrace();
}

private String getStringImage(File file){
    try {
        FileInputStream fin = new FileInputStream(file);
        byte[] imageBytes = new byte[(int)file.length()];
        fin.read(imageBytes, 0, imageBytes.length);
        fin.close();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    } catch (Exception ex) {
        Log.e(tag, Log.getStackTraceString(ex));
        toast("Image Size is Too High to upload.");
    }
    return null;
}