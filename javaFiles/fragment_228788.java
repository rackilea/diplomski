Random r3 = new Random(1L);
Random r4 = new Random(562949953421313L);

if (r3.nextLong()==r4.nextLong()){
    System.out.println("Equal");
}