// Read the hex string into a 64-bit integer
unsigned long long doubleBits;
double result;
NSScanner *scanner = [NSScanner scannerWithString:@"4173df24c969ff63"];
if ([scanner scanHexLongLong:&doubleBits]) {
    memcpy(&result, &doubleBits, sizeof(result)l
}