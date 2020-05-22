int c = (a+b)/2;
while (c != average) {              // Simpler conditional
    a = random.nextInt(100);
    b = random.nextInt(100);
    c = (a+b)/2;                    // Must update this.
    System.out.println("random a " +a);
    System.out.println("random b "+b);
}