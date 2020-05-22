List<Runnable> methods = Arrays.asList(this::operation1, this::operation2 /* etc... */);
methods.forEach(r -> {
    try {
        r.run();
    } catch (Exception ignored) {
    }
});