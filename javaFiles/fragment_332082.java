public ArrayList<Integer> findNeighboringChains(int i, int j) {
    ArrayList<Integer> neighboringChains = new ArrayList<>();

    int tmp = findChainId(i - 1, j);
    checkChain(neighboringChains, tmp);

    tmp = findChainId(i + 1, j);
    checkChain(neighboringChains, tmp);

    tmp = findChainId(i, j - 1);
    checkChain(neighboringChains, tmp);

    tmp = findChainId(i, j + 1);
    checkChain(neighboringChains, tmp);

    return neighboringChains;
}

private void checkChain(ArrayList<Integer> neighboringChains, int tmp) {
    if (tmp != -1) {
        neighboringChains.add(tmp);
    }
}