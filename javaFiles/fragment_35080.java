private Parent getAParent(int n) {
    if (n == 0) return new Parent();
    if (n == 1) return new Child();
    if (n == 2) return new Grandchild();
    throw new IllegalArgumentException();
}

Parent x4 = getAParent (0);
Parent x5 = getAParent (1);
Parent x6 = getAParent (2);