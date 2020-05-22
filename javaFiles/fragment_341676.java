long length = original.length();

DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

int pos = 0;
byte[] buffer = new byte[splitSize];
for (...) {
    ...

    // make sure you deal with file not being exactly divisible, 
    // last chunk might be smaller
    long remaining = length - pos;
    in.read(buffer, pos, (int) Math.min(splitSize, remaining));
    out.write(buffer, 0, (int) Math.min(splitSize, remaining));

    pos += splitSize;
}