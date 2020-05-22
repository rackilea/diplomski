RCT_EXPORT_METHOD(signDataWithKey:(NSString *)dataToSign
                  privateKey:(NSString *)privateKey
                  callback:(RCTResponseSenderBlock)callback)
{
  int retEr;
  char* text = (char*) [dataToSign UTF8String];
  unsigned char *data;
  unsigned long dataLen;

  // converting nsstring base64 private key to openssl RSA key

  BIO *mem = NULL;
  EVP_PKEY *pkey;
  char *private_key = (char*)[privateKey UTF8String];

  EVP_MD_CTX md_ctx;

  NSLog(@"Processing private key %s", private_key);


  mem = BIO_new_mem_buf(private_key, strlen(private_key));
  if (mem == NULL)
  {
    char buffer[120];
    ERR_error_string(ERR_get_error(), buffer);
    NSLog(@"Error loading private key %s", buffer);
  }

  // CHANGED
  pkey = PEM_read_bio_PrivateKey(mem, NULL, NULL, NULL);

  BIO_free (mem);
  if (pkey == NULL)
  {
    char buffer[120];
    ERR_error_string(ERR_get_error(), buffer);
    NSLog(@"OpenSSL error: %s", buffer);
  } else {
    NSLog(@"Successfully loaded private key");
  }
  // end of convertion

  data = (unsigned char *) text;
  dataLen = strlen(text);


  //// creating signature
  // sha256
  unsigned char hash[SHA256_DIGEST_LENGTH];
  unsigned char sign[4096];
  int signLen;



  SHA256(data, dataLen, hash);

  unsigned char *shaString = sha256_hash_string(hash);

  NSData* plainData = [NSData dataWithBytes:(const void *)shaString length:strlen(shaString)];
  NSString *base64String = [plainData base64EncodedStringWithOptions:0];

  NSLog(@"Base64 checksum %@", base64String);

  NSLog(@"SHA256 of %s is %s end", text, shaString);

  // CHANGED - Using EVP to sign now.
  EVP_SignInit(&md_ctx, EVP_sha256());
  EVP_SignUpdate(&md_ctx, shaString, strlen(shaString));
  retEr = EVP_SignFinal(&md_ctx, sign, &signLen, pkey);


  //  OLD METHOD
  //retEr = RSA_sign(NID_sha256WithRSAEncryption, shaString, strlen(shaString), sign, &signLen, rsa_private);


  NSData* signatureData = [NSData dataWithBytes:(const void *)sign length:signLen];
  NSString *base64Signature = [signatureData base64EncodedStringWithOptions:0];
  NSLog(@"Got signed data %@", base64Signature);


  //  printf("Signature len gth = %d\n", signLen);
  NSLog(@"RSA_sign: %@ signature length = %u", (retEr == 1) ? @"RSA_sign success": @"RSA_sign error", signLen);

  NSLog(@"Got signed data %@", base64Signature);


  EVP_PKEY_free(pkey);
  callback(@[base64Signature]);
}

unsigned char *sha256_hash_string (unsigned char hash[SHA256_DIGEST_LENGTH])
{
  unsigned char *outputBuffer = calloc(65, sizeof(char));

  int i = 0;

  for(i = 0; i < SHA256_DIGEST_LENGTH; i++)
  {
    sprintf(outputBuffer + (i * 2), "%02x", hash[i]);
  }

  outputBuffer[64] = 0;

  return outputBuffer;

}