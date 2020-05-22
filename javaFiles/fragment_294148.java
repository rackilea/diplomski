class Fact {
    private int i;
    private int n;
    private int fact;

    public Fact() {
        fact = 1;
        i = 1;
    }

    public Fact(int x) {
        this();
        n = x;
    }

    public void getAnswer() {
        while (i <= n) {
            fact = fact * i;
            i++;
        }
        System.out.println(fact);
    }
}

class FactMain {
    public static void main(String[] dt) {
        Fact obj = new Fact(6);
        obj.getAnswer();
    }
}