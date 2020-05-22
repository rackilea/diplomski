void onlyMe(Foo f) {
    monitorEntry(f);

    try {
        doSomething();
        monitorExit();
    } catch (Throwable any) {
        monitorExit();
        throw any;
    }
}