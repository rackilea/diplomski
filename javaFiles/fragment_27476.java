interface MathFuncFactory<T extends MathFunc> {
    T create();
}

class Generation<T extends MathFunc> {

    Generation(MathFuncFactory<T> factory) {
        for (...) {
            list.add(factory.create());
        }
    }
}