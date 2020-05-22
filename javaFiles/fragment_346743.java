final Foo foo = createFoo();

foo.lock();
inThread(() -> {
        foo.waitUntilUnlocked();
    });
long time_millisec = 100;
inThread.join(time_millisec);
bool success = inThread.isAlive();