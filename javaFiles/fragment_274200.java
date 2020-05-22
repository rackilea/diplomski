/**
 * Read a file from assets
 * 
 * @return the string from assets
 */

public static String getQuestions(Context ctx,String file_name) {

    AssetManager assetManager = ctx.getAssets();
    ByteArrayOutputStream outputStream = null;
    InputStream inputStream = null;
    try {
        inputStream = assetManager.open(file_name);
        outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
        }
    } catch (IOException e) {
    }
    return outputStream.toString();

}