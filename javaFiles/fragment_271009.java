tasks.forEach((key, task) -> {
    if (key != null && task != null) {
        key = String.join(".", Arrays.asList(key.split("\\.")).subList(0, 3));
        data.stream()
            .filter(d -> d.getCompKey().equals(key))
            .findAny()
            .ifPresent(d -> {
                task.setVal1(d.getVal1());
                task.setVal2(d.getVal2());
                task.setVal3(d.getVal3());
            });
    }
});