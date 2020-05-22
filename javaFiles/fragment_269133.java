Integer i1 = 127;
Integer i2 = 127;
System.out.println(i1++ == i2++); 
// here i1 and i2 are still 127 as you expected thus true
System.out.println(i1 == i2); 
// here i1 and i2 are 128 which are equal but not cached
    (caching range is -128 to 127),