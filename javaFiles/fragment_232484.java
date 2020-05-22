protected void Write7BitEncodedInt(int value) {
        // Write out an int 7 bits at a time.  The high bit of the byte, 
        // when on, tells reader to continue reading more bytes. 
        uint v = (uint) value;   // support negative numbers
        while (v >= 0x80) { 
            Write((byte) (v | 0x80));
            v >>= 7;
        }
        Write((byte)v); 
    }