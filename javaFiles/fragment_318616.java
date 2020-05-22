int aValue = a;
 while (aValue < 11*a) {
    handValues.add(k + aValue);
    aValue = aValue + 10; // an 1 becomes an 11,
 }
 handValues.add(k + aValue); // last case, or if a is 0