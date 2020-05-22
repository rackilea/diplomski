long x = 600851475143L;
for (int i = 3; i <= Math.sqrt(x); i += 2) {
    if (x % i == 0) {
        System.out.println(i);
        x /= i;
    }
}
System.out.println(x);