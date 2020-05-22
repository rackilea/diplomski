private void processSingle(String str) {
    ... // String-specific code
}
private void processList(List<String> strList) {
    ... // List-specific code
}
// Common interface
interface Wrapper {
    void process();
}
// Using the common interface later on
...
Wrapper w;
if (singleLine) {
    final String singleLineVal = ...
    w = new Wrapper {
        public void process() {
            processSingle(singleLineVal);
        }
    };
} else {
    final List<String> lst = ...
    w = new Wrapper {
        public void process() {
            processList(lst);
        }
    };
}
// Now we can use the unified code:
w.process();