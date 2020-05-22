abstract class Bar<T extends Bar<T>> {

    Bar<T> doSomething() {
        return this;
    }

}