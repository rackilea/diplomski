public static void copyFile(Activity c, String filename) 
{
    AssetManager assetManager = c.getAssets();

    InputStream in = null;
    OutputStream out = null;
    try 
    {
        in = assetManager.open(filename);
        String newFileName = sdcardpath/filename;
        out = new FileOutputStream(newFileName);

        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) 
        {
            out.write(buffer, 0, read);
        }
        in.close();
        in = null;
        out.flush();
        out.close();
        out = null;
    } catch (Exception e) {
        Utility.printLog("tag", e.getMessage());
    }finally{
        if(in!=null){
            try {
                in.close();
            } catch (IOException e) {
                printLog(TAG, "Exception while closing input stream",e);
            }
        }
        if(out!=null){
            try {
                out.close();
            } catch (IOException e) {
                printLog(TAG, "Exception while closing output stream",e);
            }
        }
    }
}