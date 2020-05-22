private int combinationCount(int[] containerSizes, int from, int total) {
    if (total == 0 || from == containerSizes.length - 1)
        return 1;
    int combinations = 0;
    for (int i = 0; i <= Math.min(total, containerSizes[from]); i++)
        combination += combinationCount(containerSizes, from + 1, total - i);
    return combinations;
}