String[] names = new String[] {"Alice",null,"Charly","David",null,null};
System.out.println(toStringArrayNonNulls(names));
Integer[] primes = new Integer[] {2,3,null,null,11};
System.out.println(toStringArrayNonNulls(primes));
Object[] namesAndPrimes = new Integer[] {"Alice",2,null,3,null,"Charly",null,11};
System.out.println(toStringArrayNonNulls(namesAndPrimes));