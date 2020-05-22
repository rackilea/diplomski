File original = new File(filename);
int numberOfFiles = ((int) original.length() / splitSize) + 1;

DataInputStream in = 
    new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

// <== just count through parts.
for (int i = 0; i < numberOfFiles; i++) {
    File output = new File(String.format("%s-%d", filename, i));
    // <== Part of file being output e.g. testfile.pdf-1, testfile.pdf-2

    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(output)));

}