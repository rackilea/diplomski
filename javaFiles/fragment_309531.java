1010
boolean = (1010 & 1000) == 1000 // (1000 = represents 0x80)
boolean = true (1);

1010 >>> 0100
boolean = (0100 & 1000) == 0000
boolean = false (0);

0100 >>> 1000
boolean = (1000 & 1000) == 1000
boolean = true (1);

1000 >>> 0000
boolean = (0000 & 1000) == 0000
boolean = false (0);