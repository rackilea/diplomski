class Block {
    private final int[] b;

    public IntStream getBs() {
        return Arrays.stream(b);
    }
}

public IntStream generate(List<Block> block1, List<Block> block2) {
    return block1.stream()
        .flatMapToInt(b1 -> block2.stream()
            .flatMapToInt(b2 -> b1.getBs()
                .flatMap(n1 -> b2.getBs().map(n2 -> n1 + n2)));
}