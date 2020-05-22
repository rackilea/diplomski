int n = 20;

long k1Shift = k1 >> n;
long k2Shift = k2 >> n;

System.out.println(String.format("%016x => %016x", k1, k1Shift));
System.out.println(String.format("%016x => %016x", k2, k2Shift));

0000111122223333 => 0000000001111222
4444555566667777 => 0000044445555666