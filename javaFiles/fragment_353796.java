int i;
int j;

for (j = 0; j < sizeof(n); j++) {
    i = (int)(n >> (j*8)) & 0x0ff;
    [dataToSend appendData:[NSMutableData dataWithBytes:&i length:sizeof(i)]];
}
[self send:dataToSend];