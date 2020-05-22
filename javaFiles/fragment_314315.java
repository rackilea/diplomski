private void bar() {
    try {
        foo("test");
    } catch(Exception e) {
        Log.wtf("MyApp", "Something went wrong with foo!", e);
    }
}