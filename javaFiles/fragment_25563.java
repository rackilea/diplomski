final byte assoc_resp_msg_int[] = new byte[] {
        (byte)0xe3, 0x00, //APDU CHOICE Type(AareApdu)
        0x00, 0x2c, //CHOICE.length = 44
        0x00, 0x00, //result=accept
        0x50, 0x79, //data-proto-id = 20601
        0x00, 0x26, 
        (byte)0x80,
...
}
System.out.println(assoc_resp_msg_int[10]&0xFF);
//128