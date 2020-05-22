- (SecKeyRef)addPeerPublicKey:(NSString *)peerName keyBits:(NSData *)publicKey {
OSStatus sanityCheck = noErr;
SecKeyRef peerKeyRef = NULL;
CFTypeRef persistPeer = NULL;

LOGGING_FACILITY( peerName != nil, @"Peer name parameter is nil." );
LOGGING_FACILITY( publicKey != nil, @"Public key parameter is nil." );

NSData * peerTag = [[NSData alloc] initWithBytes:(const void *)[peerName UTF8String] length:[peerName length]];
NSMutableDictionary * peerPublicKeyAttr = [[NSMutableDictionary alloc] init];

[peerPublicKeyAttr setObject:(id)kSecClassKey forKey:(id)kSecClass];
[peerPublicKeyAttr setObject:(id)kSecAttrKeyTypeRSA forKey:(id)kSecAttrKeyType];
[peerPublicKeyAttr setObject:peerTag forKey:(id)kSecAttrApplicationTag];
[peerPublicKeyAttr setObject:publicKey forKey:(id)kSecValueData];
[peerPublicKeyAttr setObject:[NSNumber numberWithBool:YES] forKey:(id)kSecReturnPersistentRef];

sanityCheck = SecItemAdd((CFDictionaryRef) peerPublicKeyAttr, (CFTypeRef *)&persistPeer);

// The nice thing about persistent references is that you can write their value out to disk and
// then use them later. I don't do that here but it certainly can make sense for other situations
// where you don't want to have to keep building up dictionaries of attributes to get a reference.
// 
// Also take a look at SecKeyWrapper's methods (CFTypeRef)getPersistentKeyRefWithKeyRef:(SecKeyRef)key
// & (SecKeyRef)getKeyRefWithPersistentKeyRef:(CFTypeRef)persistentRef.

LOGGING_FACILITY1( sanityCheck == noErr || sanityCheck == errSecDuplicateItem, @"Problem adding the peer public key to the keychain, OSStatus == %d.", sanityCheck );

if (persistPeer) {
    peerKeyRef = [self getKeyRefWithPersistentKeyRef:persistPeer];
} else {
    [peerPublicKeyAttr removeObjectForKey:(id)kSecValueData];
    [peerPublicKeyAttr setObject:[NSNumber numberWithBool:YES] forKey:(id)kSecReturnRef];
    // Let's retry a different way.
    sanityCheck = SecItemCopyMatching((CFDictionaryRef) peerPublicKeyAttr, (CFTypeRef *)&peerKeyRef);
}

LOGGING_FACILITY1( sanityCheck == noErr && peerKeyRef != NULL, @"Problem acquiring reference to the public key, OSStatus == %d.", sanityCheck );

[peerTag release];
[peerPublicKeyAttr release];
if (persistPeer) CFRelease(persistPeer);
return peerKeyRef;