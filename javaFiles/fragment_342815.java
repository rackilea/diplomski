byte b;
if (b & 0x80) ... // Test a flag
b |= 0x40; // Set a flag
b ^= 0x20; // Flip a flag from 0 to 1 or 1 to 0
b ^= ~0x10; // Clear a flag
byte x = b << 3; // Shift left 3 bits and assign
byte x = b >>> 4; // Shift right 4 bits and assign (WITHOUT sign extension)