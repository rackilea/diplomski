public class MVTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String filename = "/home/rogiel/fs/home/movies/vp.mp3.part1.rar";
        File f = new File(filename);
        Archive a = null;
        try {
            a = new Archive(new FileVolumeManager(f));
        } catch (RarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (a != null) {
            a.getMainHeader().print();
            FileHeader fh = a.nextFileHeader();
            while (fh != null) {
                try {
                    File out = new File("/home/rogiel/fs/test/"
                            + fh.getFileNameString().trim());
                    System.out.println(out.getAbsolutePath());
                    FileOutputStream os = new FileOutputStream(out);
                    a.extractFile(fh, os);
                    os.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (RarException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                fh = a.nextFileHeader();
            }
        }
    }
}