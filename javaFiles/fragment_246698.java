NSData *keyData = [NSData dataWithBase64EncodedString:secretKey];
NSData *clearTextData = [signStr dataUsingEncoding:NSUTF8StringEncoding];

uint8_t digest[CC_SHA1_DIGEST_LENGTH] = {0};

CCHmacContext hmacContext;
CCHmacInit(&hmacContext, kCCHmacAlgSHA1, keyData.bytes, keyData.length);
CCHmacUpdate(&hmacContext, clearTextData.bytes, clearTextData.length);
CCHmacFinal(&hmacContext, digest);

NSData *out = [NSData dataWithBytes:digest length:CC_SHA1_DIGEST_LENGTH];
NSString *base64Enc = [out base64Encoding];