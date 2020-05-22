public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Fraction frac = new Fraction();
    boolean isContinue = true;
    while (isContinue) {
        System.out.println("Enter numerator: ");
        frac.setNum(input.nextInt());
        System.out.println("Enter denominator: ");
        frac.setDen(input.nextInt());

        System.out.println("***************OUTPUT***************");
        System.out.println("NUMERATOR: " + frac.getNum());
        System.out.println("DENOMINATOR: " + frac.getDen());
        System.out.println("FRACTION FORM: " + frac.getShowFractionForm());
        System.out.println("LOWEST TERM: " + frac.getDetermineLowestTerm());
        System.out.println("LOWEST TERM: " + frac.getDetermineFractionType());
        System.out.println("DECIMAL EQUIVALENT: " + frac.getDetermineDecimalEquivalent());
        System.out.println("Input again? [y/n]");
        String result = input.next();
        isContinue = result.equals("y");
    }
}