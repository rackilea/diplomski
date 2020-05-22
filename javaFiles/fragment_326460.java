int version = 2;
int padding = 0;
int extension = 0;
int csrcCount = 1;
int marker = 0;
int payloadType = 8;
int sequenceNumber = 1234;
long timestamp = 1;
long ourCsrc = 4321;

byte buf[] = ...; //allocate this big enough to hold the RTP header + audio data

//assemble the first bytes according to the RTP spec (note, the spec marks version as bit 0 and 1, but
//this is really the high bits of the first byte ...
buf[0] = (byte) ((version & 0x3) << 6 | (padding & 0x1) << 5 | (extension & 0x1) << 4 | (csrcCount & 0xf));

//2.byte
buf[1] = (byte)((marker & 0x1) << 7 | payloadType & 0x7f);

//squence number, 2 bytes, in big endian format. So the MSB first, then the LSB.
buf[2] = (byte)((sequenceNumber & 0xff00) >> 8);
buf[3] = (byte)(sequenceNumber  & 0x00ff);

//packet timestamp , 4 bytes in big endian format
buf[4] = (byte)((timestamp & 0xff000000) >> 24);
buf[5] = (byte)((timestamp & 0x00ff0000) >> 16);
buf[6] = (byte)((timestamp & 0x0000ff00) >> 8);
buf[7] = (byte) (timestamp & 0x000000ff);
//our CSRC , 4 bytes in big endian format
buf[ 8] = (byte)((sequenceNumber & 0xff000000) >> 24);
buf[ 9] = (byte)((sequenceNumber & 0x00ff0000) >> 16);
buf[10] = (byte)((sequenceNumber & 0x0000ff00) >> 8);
buf[11] = (byte) (sequenceNumber & 0x000000ff);