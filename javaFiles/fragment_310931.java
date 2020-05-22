private static int calculate(int total, int depth) {
    return total == 0 ? 
        depth : 
        Stream.of(7, 5, 1)
              .map(i -> total - i  >= 0 ? calculate(total - i, depth+1) : Integer.MAX_VALUE)
              .min(Integer::compare)
              .get();
}