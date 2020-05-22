class B extends A {
    int Func(int y) {
        // e.g:
        if (y > 10) {
            return super.Func(y); // call Func from the parent class
        }
        return y + 1;
    }
}