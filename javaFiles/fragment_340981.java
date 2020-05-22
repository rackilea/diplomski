void setScoresToValue(int value) {
    Arrays.fill(this.scores, value);
    System.out.println(Arrays.toString(this.scores));
}

public static void main(String[] args) {
    SomeClass sc = new SomeClass();
    sc.setScoresToValue(255);
}