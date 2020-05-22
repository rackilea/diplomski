final byte b1 = 127;
final byte b2 = 1;
final byte b = b1 + b2; // <-- FAIL: 128 greater than Byte.MAX_VALUE

final byte b1 = 12;
final byte b2 = 3;
final byte b = b1 + b2; // <-- SUCCESS: 15 fits