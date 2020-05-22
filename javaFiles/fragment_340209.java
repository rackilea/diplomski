DataInputStream dis = new DataInputStream(new FileInputStream(inFile));
boolean eof = false;
while (!eof) {
    try {
        // read and use data
    } catch (EOFException e) {
        eof = true;
    }
}