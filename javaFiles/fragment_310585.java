public static class CopyFile implements Runnable {
    private File input;
    private File output;

    public CopyFile(File input, File output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        System.out.println("Copy file:" + input.toString());
        System.out.println("Destination:" + output.toString());

        InputStream InputReader = null;
        OutputStream OutputWriter = null;
        try {
            InputReader = new FileInputStream(input);
            OutputWriter = new FileOutputStream(output);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = InputReader.read(buffer)) > 0) {
                OutputWriter.write(buffer, 0, length);
            }
            InputReader.close();
            OutputWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}