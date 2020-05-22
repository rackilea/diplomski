unsigned char inbuf[] = "aaa&1";
unsigned char outbuf[20];
MD5(inbuf, strlen(inbuf), outbuf);

for (i = 0; i < 20; i++) {
    printf("%02x ", outbuf[i]);
}