double d = 1398101.25d;
    ByteArrayOutputStream str = new ByteArrayOutputStream();
    // for demo, use real output as needed

    long bits = Double.doubleToRawLongBits(d);
    int signByte = (int)(bits>>(63-6))&(1<<6) | (1<<7);
    // shift to the correct place to start with, and pre-add bit 8
    int exponent = ((int)(bits>>52)&0x7FF)-(1023+52);
    // don't need to box/unbox to do arithmetic
    long mantissa = (bits&0xFFFFFFFFFFFFFL) | (1L<<52);
    // add the hidden bit
    while( (mantissa&1)==0 ){ mantissa>>=1; exponent++; }
    // normalize
    byte[] exptbytes = BigInteger.valueOf(exponent).toByteArray();
    if(exptbytes.length<3) str.write(signByte|(exptbytes.length-1)); 
    else{ str.write(signByte|3); str.write(exptbytes.length); }
    // only the if branch is actually needed 
    str.write (exptbytes);
    str.write (BigInteger.valueOf(mantissa/*>>scale*/).toByteArray());

    System.out.println(Arrays.toString(str.toByteArray()));
    // for demo