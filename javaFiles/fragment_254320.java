byte b05 = (byte) 0x7A;
byte b06 = (byte) 0x00; // MSB, positive as < 0x80

nyte[] byteTabDay = new byte[2];
byteTabDay[0] = b05;
byteTabDay[1] = b06;    

int valueDay  =  ((int) byteTabDay[1]) << 8) | (0xFF & byteTabDay[0]); 
System.out.println("day :" + valueDay); // print 122