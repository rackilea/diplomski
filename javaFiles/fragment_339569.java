CloseHandler closeAll = new CloseHandler();
try (Stream<Something> stream = list.stream().onClose(closeAll)) {
    // Now collect
    stream.collect(Collectors.groupingBy(
        this::extractFileName, 
        toFile(closeAll)));
}