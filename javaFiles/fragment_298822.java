static int nrOfFails = 0;
private static int solutions(int[] money, int c, int target, ArrayList<Integer> s)
{
    assert money != null : "array should be initialized";
    assert c >= 0 && c <= money.length;

    if (target == 0) {
        showSolution(s);
        return 1;
    } else if (target < 0 || c >= money.length) {
        nrOfFails++;
        return 0;
    } else {
        s.add(money[c]);
        int with = solutions(money, c + 1, target - money[c], s);
        s.remove(s.size() - 1);
        int without = solutions(money, c + 1, target, s);
        return with + without;
    }
}