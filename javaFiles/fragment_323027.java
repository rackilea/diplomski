public static void main(String[] args) {
    Compound c = new Compound();
    c.add("H", 2);
    System.out.println(c.getCompound());
    c.add("H", 1);
    System.out.println(c.getCompound());
    c.add("O", 6);
    c.add("H", 4);
    System.out.println(c.getCompound());
}