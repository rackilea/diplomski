...
UniSubroutine readBlkSub = unisession.subroutine(routineName, 4);
readBlkSub.setArg(0, getNameID());
readBlkSub.setArg(1, itemName);
readBlkSub.call();
final String SUCCESS = "0";
if (readBlkSub.getArg(3).equals(SUCCESS)) {
    encodedObjectCode = readBlkSub.getArg(2);
    sun.misc.BASE64Decoder decoder = new BASE64Decoder();
    byte[] decodedBytes = decoder.decodeBuffer(encodedObjectCode);
    ...
}