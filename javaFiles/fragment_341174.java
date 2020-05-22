public class ConcatFiles {

    public static void main(String[] args) throws IOException {
        // concatenate the single gzip files to one gzip file
        try (InputStream isOne = new FileInputStream("file1.gz");
                InputStream isTwo = new FileInputStream("file2.gz");
                InputStream isThree = new FileInputStream("file3.gz");
                SequenceInputStream sis =  new SequenceInputStream(new SequenceInputStream(isOne, isTwo), isThree);
                OutputStream bos = new FileOutputStream("output_all_three.gz")) {
            byte[] buffer = new byte[8192];
            int intsRead;
            while ((intsRead = sis.read(buffer)) != -1) {
                bos.write(buffer, 0, intsRead);
            }
            bos.flush();
        }

        // ungezip the single gzip file, the output contains the
        // concatenated input of the single uncompressed files 
        try (GZIPInputStream gzipis = new GZIPInputStream(new FileInputStream("output_all_three.gz"));
                OutputStream bos = new FileOutputStream("output_all_three")) {
            byte[] buffer = new byte[8192];
            int intsRead;
            while ((intsRead = gzipis.read(buffer)) != -1) {
                bos.write(buffer, 0, intsRead);
            }
            bos.flush();
        }
    }
}