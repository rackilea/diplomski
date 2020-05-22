- (BOOL)isPasswordValid 
{
    NSString * saltString = @"[B@b120b400";
    NSString * storedPasswordString = @"90bd42e6f15ccd2d3ec3386d031758898bb7bc08f476a3d7afe6fe1cfbc372e6";

    NSData * hashData = [storedPasswordString dataFromHexString];

    unsigned char out[[hashData length]];

    PKCS5_PBKDF2_HMAC_SHA1("password", strlen("password"), 
                          (const unsigned char *)[saltString UTF8String], 
                          strlen([saltString UTF8String]), 1000, 
                                  [hashData length], out);

    NSMutableString * hashTestString = [NSMutableString new];
    for (NSInteger idx = 0; idx < sizeof(out); idx++) {
      [hashTestString appendString:[NSString stringWithFormat:@"%02x", out[idx]]];
    }

    NSData * hashDataTest = [hashTestString dataFromHexString];

    const char * hashBytes = [hashData bytes];
    const char * hashBytesTest = [hashDataTest bytes];

    int diff = hashData.length ^ hashDataTest.length;
    for (int i = 0; i < hashData.length && i < hashDataTest.length; i++) {
        diff |= hashBytes[i] ^ hashBytesTest[i];
    }

    return diff == 0;
}