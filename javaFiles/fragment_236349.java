public List<List<Integer>> generate(int numRows) {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> prev = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    if (numRows <= 0)
        return res;

    prev.add(1);
    res.add(new ArrayList<>(prev));
    if (numRows == 1)
        return res;

    prev.add(1);
    res.add(new ArrayList<>(prev));
    if (numRows == 2)
        return res;

    int k = 3;

    while (k <= numRows) {

        Integer[] arr = prev.toArray(new Integer[prev.size()]);
        curr.clear();
        curr.add(1);
        for (int i = 0; i < arr.length - 1; i++) {
            curr.add(arr[i] + arr[i + 1]);

        }
        curr.add(1);
        for (int i : curr)
            System.out.print(i + " ");
        System.out.print("\n");
        res.add(new ArrayList<>(curr));
        prev = curr;
        k++;
    }

    return res;
}