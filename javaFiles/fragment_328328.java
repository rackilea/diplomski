private int Max;

public int getMax() {
    return Max;
}

public static void main(String[] args) {
    Main Max = new Main();
    Max.printMax();
}

public void myMethod() {
    int Lee = 6;
    this.Max = Lee;
}

public void printMax() {
    this.myMethod();
    int variable = this.getMax();
    System.out.println(variable);
}