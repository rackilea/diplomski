byte b = 5; //ok: b is a byte and 5 is an int between -128 and 127
byte b = 1000; //not ok: 1000 is an int but is not representable as a byte (> 127)
byte b = 5L; //not ok: 5L is a long (and not a byte, short, char or int)
int i = 5L; //not ok: i is not a byte, short or char
int i = 5; byte b = i; //not ok: i is not a constant
final int i = 5; byte b = i; //ok: i is a constant and b is a byte