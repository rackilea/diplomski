ByteBuffer bb = ByteBuffer.allocate(36);
a.getContent(bb);
bb.position(0);
double [] m = {
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint0230(bb),
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint0230(bb),
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint1616(bb),
    IsoTypeReader.readFixedPoint0230(bb)};