class Sub1 extends Super {
    public Super copy(Super input) {
        return new Sub1(input);
    }
}

class Sub2 extends Super {
    public Super copy(Super input) {
        return new Sub2(input);
    }
}