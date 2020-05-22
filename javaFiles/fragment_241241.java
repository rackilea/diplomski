static int c = 0;

public void knownNonThreadSafeMethod(final File file) throws IOException {
    int t = ++c;
    doSomething();   
    assert t == c; //smart-ass compiler will optimize to 'true'
}