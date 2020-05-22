- (NSString *)convertTokenToDeviceID:(NSData *)token {
NSMutableString *deviceID = [NSMutableString string];

// iterate through the bytes and convert to hex
unsigned char *ptr = (unsigned char *)[token bytes];

for (NSInteger i=0; i < 32; ++i) {
    [deviceID appendString:[NSString stringWithFormat:@"%02x", ptr[i]]];
}

return deviceID;