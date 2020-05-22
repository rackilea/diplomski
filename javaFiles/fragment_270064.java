FileOutputStream fos = null;
ObjectOutputStream os = null;

try {
    fos = new FileOutputStream(YOUR_FILE_NAME);
    os = new ObjectOutputStream(fos);

    for(YourObjectType current : YourQueue){
        os.writeXXX(current);  //Where XXX is the appropriate write method depending on your data type
        os.writeChars(",");  //Since you mentioned wanting a comma delimiter..
    }
} catch(IOException e){
   e.printStackTrace(); 
} finally {
    if(fos != null) fos.close();
    if(os != null) os.close();
}