try (FileInputStream fis = new FileInputStream(new File("rawFilePath", "test.vmd"))) {
    DataInputStream dis = new DataInputStream(fis);
    byte[] nameBytes = new byte[15];
    dis.read(nameBytes);
    int index = 0;
    for (int i = 0; i < nameBytes.length; i++) {
        if (nameBytes[i] == 0) {
            index = i;
            break;
        }
    }
    String name = new String(nameBytes, 0, index, "8859_1");
    // Java ints are signed, so to keep an unsigned int we need long
    long frameNumber = dis.readInt() & 0xffffffff;
    float boneXPosCoordinate = dis.readFloat();
    float boneYPosCoordinate = dis.readFloat();
    float boneZPosCoordinate = dis.readFloat();
    float boneXRotCoordinate = dis.readFloat();
    float boneYRotCoordinate = dis.readFloat();
    float boneZRotCoordinate = dis.readFloat();
    float boneWRotCoordinate = dis.readFloat();
    byte[] interpolationData = new byte[64];
    dis.read(interpolationData);
}