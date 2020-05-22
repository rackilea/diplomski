doSomething(A a) {
    if (a instanceof A1) {
        A1 a1 = (A1) a;
        a1.methodSpecificToA1();
    } else if (a instanceof A2) {
        A2 a2 = (A2) a;
        a2.methodSpecificToA2();
    }
}