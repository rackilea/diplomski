String prefix = "/users/rama/";
String filePath = "xyz/abc/file1.txt";

// concatenation => /users/rama/xyz/abc/file1.txt
String fullPath = prefix.concat(filePath);

PrintWriter writer;
try {

    // Getting the directory path : /users/rama/xyz/abc/
    int lastIndexOfSlash = fullPath.lastIndexOf("/");
    String path = filePath.substring(0, lastIndexOfSlash);

    File file = new File(path);

    // If /users/rama/xyz/abc/ don't exist then creating it. 
    if(!file.exists()) {
        file.mkdirs();
    }

    // Creating the file. 
    writer = new PrintWriter(fullPath, "UTF-8");
    writer.println("content");
    writer.close();
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (UnsupportedEncodingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}