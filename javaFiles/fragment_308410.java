/**
 *  Reads a file and returns its content as byte array
 * @param file file that should be returned as byte array
 * @return byte[] array of bytes of the file
 */
public static byte[] convertTextFileToByteArray(File file) {
    FileInputStream fileInputStream = null;
    byte[] bFile = new byte[(int) file.length()];
    try {
        fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();
    }catch(Exception e){
        e.printStackTrace();
    } finally {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream = null;
        }
    }
    return bFile;
}