double valueUnsigned;
if (value < 0) {
    valueUnsigned = (value & 0x7FFFFFF) + 0x80000000l;
} else {
    valueUnsigned = value;
}
System.out.println("Maths solution " + Math.floor(1d + Math.log(valueUnsigned) / Math.log(2)));