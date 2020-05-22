NSString *valid1 = @"ae";
    NSString *valid2 = @"0xae";
    NSString *valid3 = @"0Xae";
    NSString *invalid1 = @"ze";
    NSString *invalid2 = @"hello";

    void (^scanBlock)(NSString *) = ^(NSString *toScan) {
        NSScanner *scanner = [NSScanner scannerWithString:toScan];
        UInt32 parsed = 0;
        BOOL success = [scanner scanHexInt:&parsed];
        NSLog(
            @"Scanner %@ able to scan the string %@. parsed's value is %x",
            success ? @"was" : @"wasn't",
            toScan,
            parsed);
    };

    for (NSString *valid in @[ valid1, valid2, valid3]) {
        scanBlock(valid);
    }

    for (NSString *invalid in @[invalid1, invalid2]) {
        scanBlock(invalid);
    }