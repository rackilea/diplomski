public class IOUtil {

    public BufferedReader fileZipReader(String fileName) throws IOException, URISyntaxException {
        URL zipUrl = IOUtils.class.getClassLoader().getResource(fileName);
        File zipFile = new File(zipUrl.toURI());
        ZipFile zip = new ZipFile(zipFile);
        for (Enumeration e = zip.entries(); e.hasMoreElements(); ) {
            ZipEntry zipEntry = (ZipEntry) e.nextElement();
            if (!zipEntry.isDirectory()) {
                return new BufferedReader(new InputStreamReader(zip.getInputStream(zipEntry)));
            }
        }
        throw new FileNotFoundException("File not found: " + fileName);
    }

    public static void main(String[] args) throws Exception {
        IOUtil util = new IOUtil();

        BufferedReader br = util.fileZipReader("dia/test.txt.zip");
    }
}