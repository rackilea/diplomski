- (void)generatePublicKeyByFile {
NSString *publicKeyPath = [[NSBundle mainBundle] pathForResource:@"public_key"
ofType:@"der"];
NSData *publicKeyFileContent = [NSData dataWithContentsOfFile:publicKeyPath];
NSData *publicKey = [self extractPublicKeyFromRawFormattedKey:publicKeyFileContent];
[[SecKeyWrapper sharedWrapper] removePeerPublicKey:@"peerName"]; //remove public key if it is already added.
SecKeyRef publicKeyRef = [[SecKeyWrapper sharedWrapper]addPeerPublicKey:@"peerName" keyBits:publicKey]; //our goal.    
}