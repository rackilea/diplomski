class Foo {
    Queue<String> _slices = new ArrayDeque<>();
    void push(String element) {
        _slices.add(element);
    }
    void poll() {
        while (!_slices.empty()) {
            // ...
        }
    }
}