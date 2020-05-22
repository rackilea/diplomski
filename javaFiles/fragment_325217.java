for (int i = 0; i < height; i++) {
    StringJoiner joiner = new StringJoiner(" ");
    for (int j = 0; j < width; j++) {
        int value = matrix.get((height + i - 1) % height).get(j)
            + matrix.get((height + i + 1) % height).get(j)
            + matrix.get(i).get((width + j - 1) % width)
            + matrix.get(i).get((width + j + 1) % width);
        joiner.add(String.valueOf(value));
    }
    System.out.println(joiner.toString());
}