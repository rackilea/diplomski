int cla = 0x00;
int ins = 0xA2;
int p1  = 0x00;
int p2  = 0x00;
//int LC  = 0x08;'
byte[] data = new byte[] {(byte) 0xEF, (byte) 0x08};
int le  = 0x0D;

ResponseAPDU respApdu = channel.transmit(
                             new CommandAPDU(cla, ins, p1, p2, data, le));