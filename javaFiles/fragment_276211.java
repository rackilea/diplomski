public int countChars() {
    Set<Character> set = new HashSet<Character>();

    for (int r = 0; r < height; ++r) {
        for (int c = 0; c < width; ++c) {
            if (space[r][c] != '.' && space[r][c] != '|') {
                set.add(new Character(space[r][c]));
            }
        }
    }

    return set.size();
}