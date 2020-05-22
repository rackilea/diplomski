parent.stream().forEach(i -> {
    if (i instanceof List) {
        printRecursiveList((List) i);
    } else {
        System.out.println(i);
    }
});