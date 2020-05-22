// first create an array for the Byte Order Mark
    final byte[] bom = new byte[] { (byte) 239, (byte) 187, (byte) 191 }; 
    try (OutputStream os = response.getOutputStream()) {
        os.write(bom);

        final PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
        w.print(data);
        w.flush();
        w.close();
    } catch (IOException e) {
        // logit
    }