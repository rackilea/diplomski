public static void main(String[] args) {

    String[] aInitial = {"a", "b", "c"};
    String[] bInitial = {"0", "1"};

    Flux<String> fluxA = Flux.fromArray(aInitial);
    Flux<String> fluxB = Flux.fromArray(bInitial);

    fluxA
            .flatMap(input1 -> fluxB.map(input2 -> foo(input1, input2)))
            .doOnNext(System.out::println)
            .blockLast();
}

private static String foo(String a, String b) {
    return a + ", " + b;
}