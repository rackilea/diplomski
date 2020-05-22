BufferedReader reader = null;
reader = new BufferedReader(
        new InputStreamReader(getAssets().open("nouns.txt"), "UTF-8")); 

// do reading, usually loop until end of file reading 
String mLine;
while ((mLine = reader.readLine()) != null) {
       //process 
       ...
}