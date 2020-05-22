Random r = new Random(0L);
Random r2 = new Random(562949953421312L);

if (r.nextLong()==r2.nextLong()){
    System.out.println("Equal"); //You WILL get this!
}