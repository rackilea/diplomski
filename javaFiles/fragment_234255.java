public static void main(String args[]) throws CloneNotSupportedException {
    Gene g1 = new Gene(new char[]{'a', 'b', 'c', 'd'});
    Gene g2 = (Gene)(g1.clone());

    // now Let's modify g1
    g1.setUnit(0, 'e');
    g1.setUnit(1, 'f');
    g1.setUnit(2, 'g');
    g1.setUnit(3, 'h');

    System.out.println("g1: " + g1);
    System.out.println("g2: " + g2);   // g2 has not changed
}