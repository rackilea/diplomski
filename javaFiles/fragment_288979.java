public static void init() { ... }
public static void doSomething() { ... }
public static void shutdown() { ... }

public static Runnable setup(Runnable r) {
    return () -> {
        init();
        r.run();
        shutdown();
    };
}

public static Runnable loop(Runnable r) {
    return () -> {
        while (someCondition) {
            r.run();
        }
    };
}

// I used "Main" here because this in a class called Main. Replace "Main" with the name of your class
public static void task1() {
    setup(loop(Main::doSomething)).run();
}

public static void task2() {
    loop(setup(Main::doSomething)).run();
}