public class SomeTest {

    private static HashSet<String> filez = new  HashSet<String> (); 

    public static void walkin(File dir, PrintWriter out) {
        String pattern = ".mp4";
        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].getName().endsWith(pattern) && listFile[i].isFile()) {
                    //System.out.println(listFile[i].getPath());
                    if (filez.add(listFile[i].getPath())) {
                        out.write(listFile[i].toString());
                        out.write("\r\n");
                    }
                } else {
                    walkin(listFile[i], out);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File dir = new File("C:\\mydir");
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter("D:\\nawaaaaaa.txt", true)));
            walkin(dir, out);
            out.close();
        } catch (IOException e) {
           //
        }
    }
}