public void check(Set<Laptops> laptops, File under2000file, File over2000file){
    try {
        PrintStream under2000 = new PrintStream(under2000file);
        PrintStream over2000 = new PrintStream(over2000file);
        for(Laptop laptop: laptops) {
           if(laptop.getPrice() < 2000) {
               under2000.println(laptop);
           } else {
               over2000.println(laptop);
           }
        }
        under2000.close();
        over2000.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

}