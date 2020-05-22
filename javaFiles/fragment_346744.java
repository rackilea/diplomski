final Foo foo = createFoo();

inThread(() -> {
        foo.waitUntilUnlocked();
    });
inThread.join();
return true; //success