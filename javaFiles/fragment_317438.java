- (NSString *)encrypt:(NSString *)encryptValue {
    // first of all we need to prepare key with md5
    // setup md5 context with salt and key
    NSString *key = @"foo";
    unsigned char md5Buffer[CC_MD5_DIGEST_LENGTH];
    memset(md5Buffer, 0, CC_MD5_DIGEST_LENGTH);
    NSData *keyData = [key dataUsingEncoding:NSUTF8StringEncoding];
    CC_MD5_CTX md5Ctx;
    CC_MD5_Init(&md5Ctx);
    CC_MD5_Update(&md5Ctx, [keyData bytes], [keyData length]);
    unsigned char salt[] =  {0x10,0x1B,0x12,0x21,0xba,0x5e,0x99,0x12};
    CC_MD5_Update(&md5Ctx, salt, 8);
    CC_MD5_Final(md5Buffer, &md5Ctx);

    // do md5 hashing
    CC_MD5(md5Buffer, CC_MD5_DIGEST_LENGTH, md5Buffer);

    // our key is ready, let's prepare other buffers and moved bytes length
    NSData *encryptData = [encryptValue dataUsingEncoding:NSUTF8StringEncoding];
    size_t resultBufferSize = [encryptData length] + kCCBlockSizeDES;
    unsigned char resultBuffer[resultBufferSize];
    size_t moved = 0;

    // DES-CBC requires an explicit Initialization Vector (IV)
    // IV - second half of md5 key
    unsigned char IV[kCCBlockSizeDES];
    memcpy(IV, md5Buffer + CC_MD5_DIGEST_LENGTH / 2, sizeof(IV));

    CCCryptorStatus cryptorStatus = CCCrypt(kCCEncrypt, kCCAlgorithmDES,
                                        kCCOptionPKCS7Padding, md5Buffer,
                                        CC_MD5_DIGEST_LENGTH/2, IV,
                                        [encryptData bytes], [encryptData length],
                                        resultBuffer, resultBufferSize, &moved);

    if (cryptorStatus == kCCSuccess) {
        return [[NSData dataWithBytes:resultBuffer length:moved] base64EncodedStringWithOptions:0];
    } else {
        return nil;
    }
}