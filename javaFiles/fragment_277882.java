String line;
try (InputStream fis = new FileInputStream("AbsoluteFilePath");
     InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
     BufferedReader br = new BufferedReader(isr);) {

    while ((line = br.readLine()) != null) {
        // do whatever with line

    }
}