NSString *nib = @"003500970000199613031";

int weight[] = { 73, 17, 89, 38, 62, 45, 53, 15, 50, 5, 49, 34, 81, 76, 27, 90, 9, 30, 3 };
NSInteger sum = 0;
for (int i = 0; i < 19; i++) {
    sum += [[nib substringWithRange:NSMakeRange(i, 1)] intValue] * weight[i];
}
int checkDigit = [[nib substringFromIndex:19] intValue];
if (checkDigit == (98 - (sum % 97))) {
    NSLog(@"VALID");
} else {
    NSLog(@"NOT VALID");
}