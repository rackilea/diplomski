public static void main(String[] args) {

    ArrayList<String> al = new ArrayList<String>();
    al.add("String1");
    al.add("String2");

    try {
        // Create the file
        FileOutputStream fos = new FileOutputStream("MyFile.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        /* saves the characters as a dictionary into the file before the binary seq */
        for (String str : al) {
            dos.writeChars(str);
        }

        System.out.println("\nIS SUCCESFULLY WRITTEN INTO FILE! ");

        dos.writeChars("><");
        String strseq = "001100111100101000101010111010100100111000000000";

        // Ensure that you have a string of the correct size
        if (strseq.length() % 8 != 0) {
            throw new IllegalStateException(
                    "Input String is cannot be converted to bytes - wrong size: "
                            + strseq.length());
        }

        int numBytes = strseq.length() / 8;
        for (int i = 0; i < numBytes; i++) {
            int start = i * 8;
            int end = (i + 1) * 8;
            byte output = (byte) Integer.parseInt(strseq.substring(start, end), 2);
            dos.write(output);
        }

        dos.writeChars("> Enf of File");
        dos.flush();
        // Close the output stream
        dos.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}