public final Class MoneyI implements Money {

    public MoneyI(int a, Currency b) {
    }

    public MoneyI(int a, String b) { 
        this(a, Currency.getInstance(b.equals("A") ? "B" : b));
        b = b.equals("A") ? "B" : b;
    }

}