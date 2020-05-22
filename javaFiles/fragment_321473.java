public class Test {

public static void main(String[] args) {
    Test test = new Test();
    int j = 0;
    test.setToOne(j);
    assert j == 1;
}

public void setToOne(int i) {
    i = 1;
}
}