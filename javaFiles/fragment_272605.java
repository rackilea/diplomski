public static Set<List<Integer>> combinationSum(int[] candidates, int target)
{
--->>    Set<List<Integer>> res = new HashSet<>();
    Arrays.sort(candidates);
    helper(candidates, target, res, new ArrayList<>(), 0);
    return res;
}

private static void helper(int[] candidates, int target, Set<List<Integer>> res, List<Integer> temp, int index) {
    if( target < 0) return;
    if(target == 0) {
        ArrayList<Integer> newRes = new ArrayList<>(temp);
--->>        Collections.sort(newRes);

        res.add(newRes);
        return;
    }

    for(int i = index; i < candidates.length; i++) {
        if(candidates[i] > target) {
            return;
        }

        temp.add(candidates[i]);
        helper(candidates, target - candidates[i], res, temp, index);
        temp.remove(temp.size() - 1);
    }
}