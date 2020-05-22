private int unsigned_int(byte b) {
     if(b >= 0) {
         return b;
     }
     else {
         return 256 + b;
     }
}