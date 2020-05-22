class Clock extends Struct { // Hardware clock mapped to memory.
     Unsigned16 seconds  = new Unsigned16(5); // unsigned short seconds:5 bits
     Unsigned16 minutes  = new Unsigned16(5); // unsigned short minutes:5 bits
     Unsigned16 hours    = new Unsigned16(4); // unsigned short hours:4 bits
     ...
 }