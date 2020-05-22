int a;
volatile int x;

public void action1() {
    a = 100;  --- normal store
    x = 123;  ---volatile store
}

public void action2() {
    int x = x; ---volatile load
    int k = a; ---normal load
}