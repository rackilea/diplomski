private Exception someComplicatedLogicThatGivesAnException() { ... }

public void foo() {
    if (...) {
        throw someComplicatedLogicThatGivesAnException();
    }
}