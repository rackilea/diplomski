public static void printMessage(A obj) {
    obj.foo();
}

public static void main(String[] args) {
    A b = new B();
    printMessage(b); // prints 'B'
    A c = new C();
    printMessage(c); // prints 'C'
}