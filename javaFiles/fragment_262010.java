privat Stream<Integer> method1(List<String> list) {
    try (final Stream<String> myStream = list.stream()) {
        Stream<Integer> integerStream = myStream.onClose(r)
                .map(String::length).onClose(r1);
        return integerStream;
    }
}
Runnable r = ()->{
    System.out.println("closed main stream...");
};
Runnable r1 = ()->{
    System.out.println("closed map stream...");
};