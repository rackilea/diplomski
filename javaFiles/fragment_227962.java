interface X {
    double getA();
    double getB();
    double getC();
};

interface ArrayOfX {
    X get(int index);
};

class ContiguousArrayOfX implements ArrayOfX {
    class ContiguousX implements X {
        int index;
        ContiguousX(int index) {
            this.index = index; }
        double getA() { return a[index]; }
        double getB() { return b[index]; }
        double getC() { return c[index]; }
    }

    X get(int index) {
        return new ContiguousX(index); }

    double a[] = new double [SIZE];
    double b[] = new double [SIZE];
    double c[] = new double [SIZE];
};