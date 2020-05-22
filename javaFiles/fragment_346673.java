private static final String FORMULA = "(#{a} + #{b}) * (#{a} + #{b} * #{b} - #{a})";
private List<Pair<Integer, Integer>> input = Arrays.asList(
        new ImmutablePair<>(1, 2),
        new ImmutablePair<>(2, 2),
        new ImmutablePair<>(3, 1),
        new ImmutablePair<>(4, 2),
        new ImmutablePair<>(1, 5)
);

public void calculate() {
    List<String> output = input.parallelStream()
            .map(pair -> this.calculate(pair.getLeft(), pair.getRight()))
            .collect(Collectors.toList());
    System.out.println("Calculation result => " + output);
}

private String calculate(Integer a, Integer b) {
    System.out.println(Thread.currentThread()+" does calculation of ("+a+","+b+")");
    Evaluator eval = new Evaluator();
    eval.putVariable("a", a.toString());
    eval.putVariable("b", b.toString());

    try {
        String result = eval.evaluate(FORMULA);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread()+" with ("+a+","+b+") done.");
        return result;
    } catch (EvaluationException | InterruptedException e) {
        throw new RuntimeException(e);
    }
}