- (NSData *) extractPublicKeyFromRawFormattedKey: (NSData *) rawFormattedKey {
/* Now strip the uncessary ASN encoding guff at the start */
unsigned char * bytes = (unsigned char *)[rawFormattedKey bytes];
size_t bytesLen = [rawFormattedKey length];

/* Strip the initial stuff */
size_t i = 0;
if (bytes[i++] != 0x30)
    return FALSE;

/* Skip size bytes */
if (bytes[i] > 0x80)
    i += bytes[i] - 0x80 + 1;
else
    i++;

if (i >= bytesLen)
    return FALSE;

if (bytes[i] != 0x30)
    return FALSE;

/* Skip OID */
i += 15;

if (i >= bytesLen - 2)
    return FALSE;

if (bytes[i++] != 0x03)
    return FALSE;

/* Skip length and null */
if (bytes[i] > 0x80)
    i += bytes[i] - 0x80 + 1;
else
    i++;

if (i >= bytesLen)
    return FALSE;

if (bytes[i++] != 0x00)
    return FALSE;

if (i >= bytesLen)
    return FALSE;

/* Here we go! */
NSData * extractedKey = [NSData dataWithBytes:&bytes[i] length:bytesLen - i];

return extractedKey;