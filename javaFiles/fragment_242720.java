class Board
{
    public static Board fromLong(long value) {
        int[] positions = new int[16];
        List<Integer> possibilities = new ArrayList<Integer>(16);
        for (int i = 15; i >= 0; i--)
            possibilities.add(i);

        long ignore = 0;
        for (int i = 15; i > 0; i--) {
            // Rounds towards zero
            long index = (value - ignore) / factorial(i);
            ignore += index * factorial(i);
            positions[i] = possibilities.remove(index);
        }
        positions[0] = possibilities.get(0);

        return new Board(positions);
    }

    /* Note that while this returns a long, only the lowest 45 bits contain data */
    public long toLong() {
        List<Integer> possibilities = new ArrayList<Integer>(16);
        for (int i = 15; i >= 0; i--)
            possibilities.add(i);

        long value = 0;
        for (int i = 15; i > 0; i--) {
            int position = positions[i];
            int index = possibilities.indexOf(position);
            value += index * factorial(i);
            possibilities.remove(index);
        }
        return value;
    }
}