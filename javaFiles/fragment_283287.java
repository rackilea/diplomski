public String fileReading(Context c) throws IOException {
   StringBuilder sb = new StringBuilder();      
   AssetManager am = c.getAssets();
    InputStream is = am.open("a.txt");
    .....
    .....
}