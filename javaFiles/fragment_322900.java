public int foo() {
    Resource f = new Resource();
    try {
        DoSomething(f);
    }
    finally {
        f.Release();
    }
}