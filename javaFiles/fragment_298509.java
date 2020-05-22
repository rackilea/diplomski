public static void main(String[] args) {

    RandomBag bag = new RandomBag();   

    Object tileID = null;
    if (bag.size() > 0)
        tileID = bag.randomPick(); 
    System.out.println(tileID);

}