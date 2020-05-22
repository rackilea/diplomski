//can use length function for CLOBs:
@Lob char[] a;
@Lob Character b;
@Lob String c;

//can not use length function for BLOBs:
@Lob byte[] d;
@Lob Byte e;
@Lob Serializable f;