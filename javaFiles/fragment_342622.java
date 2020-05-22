public static void main(String[] args) throws IOException {
    byte[] buffer = new byte[1024];

    File inFile = new File("image_old.jpg");
    File outFile = new File("image_new.jpg");

    InputStream in = new FileInputStream(inFile);
    try {
        OutputStream out = new FileOutputStream(outFile);

        try {
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }
        finally {
            out.close();
        }
    }
    finally {
        in.close();
    }
}