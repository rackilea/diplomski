NSString *greyArea1 = @"x23";
    NSString *greyArea2 = @"artichoke";
    NSString *greyArea3 = @"1z";
    NSString *greyArea4 = @"     a3";

    for (NSString *grey in @[greyArea1, greyArea2, greyArea3, greyArea4]) {
        scanBlock(grey);
    }