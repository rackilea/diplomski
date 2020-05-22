QuadraticEquation eq = new QuadraticEquation(1, 2, 1);
if (eq.hasSolutions()) {
    if (eq.getSolution1() == eq.getSolution2()) {
        System.out.println("Equation has solution " + eq.getSolution1();
    } else {
        System.out.println("Equation has solutions " + eq.getSolution1() + 
           " and " + eq.getSolution2());
    }
} else {
    System.out.println("Equation has no real solutions ");
}