public static boolean isSolvable(int index, List<Integer> board, List<Integer> visitedIndices) {
    int lastIndex = board.size() - 1;
    if (index == lastIndex) {
        // Last index. solved
        return true;
    }

    if (index > lastIndex || index < 0 || visitedIndices.contains(index)) {
        // Outside list or previously vistied, failed to solve
        return false;
    }

    visitedIndices.add(index);
    int nextIndexForward = index + board.get(index);
    int nextIndexBackward = index - board.get(index);

    return isSolvable(nextIndexForward, board, visitedIndices)
           || isSolvable(nextIndexBackward, board, visitedIndices);
}