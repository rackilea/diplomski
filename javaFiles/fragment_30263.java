interface Trait {
    void bar();
}

abstract class Trait$class {
    public static void bar(Trait thiz) {/*trait implementation*/}
}

class Foo implements Trait {
    public void bar() {
        Trait$class.bar(this);  //works because `this` implements Trait
    }
}