try {
    InputStream inputStream = getAssets().open("textfile.txt");
    builder1.setMessage(convertStreamToString(inputStream));
} catch (IOException e){
    // Log exception
}