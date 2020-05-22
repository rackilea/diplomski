class DominicFile {

    static boolean equalfiles(File f1, File f2) {
        byte[] b1 = getBytesFromFile(f1);
        byte[] b2 = getBytesFromFile(f2);

        if(b1.length != b2.length) return false;
        for(int i = 0; i < b1.length; i++) {
            if(b1[i] != b2[i]) return false;
        }
        return true;
    }

    // returns the index (0 indexed) of the first difference, or -1 if identical
    // fails for files 2G or more due to limitations of "int"... use long if needed
    static int firstDiffBetween(File f1, File f2) {
        byte[] b1 = getBytesFromFile(f1);
        byte[] b2 = getBytesFromFile(f2);

        int shortest = b1.length;
        if(b2.length < shortest) shortest = b2.length;
        for(int i = 0; i < shortest; i++) {
            if(b1[i] != b2[i]) return i;
        }
        return -1;
    }

    // Returns the contents of the file in a byte array.
    // shamelessly stolen from http://www.exampledepot.com/egs/java.io/file2bytearray.html
    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }


}