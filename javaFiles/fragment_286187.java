NSUInteger    test = 71508;

// Java compatibility
u_int32_t bigEndianTest = CFSwapInt32BigToHost( test );

// Writes the value
NSMutableData * outputData = [ [ NSData dataWithBytes:&bigEndianTest length:saltSize ] mutableCopy ];