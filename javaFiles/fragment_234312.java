if (d1 < d2)
    return -1;           // Neither val is NaN, thisVal is smaller
if (d1 > d2)
    return 1;            // Neither val is NaN, thisVal is larger

// Cannot use doubleToRawLongBits because of possibility of NaNs.
long thisBits    = Double.doubleToLongBits(d1);
long anotherBits = Double.doubleToLongBits(d2);

return (thisBits == anotherBits ?  0 : // Values are equal
        (thisBits < anotherBits ? -1 : // (-0.0, 0.0) or (!NaN, NaN)
         1));                          // (0.0, -0.0) or (NaN, !NaN)