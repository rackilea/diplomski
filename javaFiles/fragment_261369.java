public static String randomKey(){
    String[] crates ={"Basic", "Classic", "Crazy", "Galactic"};
    Random random = new Random();
    int RandomNumber = random.nextInt(crates.length);
    System.out.println(crates[RandomNumber]);
    return crates[RandomNumber];
}