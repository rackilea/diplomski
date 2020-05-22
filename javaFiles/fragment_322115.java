public void dfs(int[] nums, int index, int length, int end, List<Integer> hs) {
    if (index > end) {
        return;
    }
    for (int i = index; i <= end; i++) {
        if (hs.size() == 0) {
            hs.add(nums[i]);
            length++;
        }
        else if (nums[i] > hs.get(hs.size() - 1)) {
            hs.add(nums[i]);
            length++;
        }
        else if (i == end && nums[i] < hs.get(hs.size() - 1)) { //(1) 
            maxLength = Math.max(maxLength, hs.size());
        }
        else if (nums[i] < hs.get(hs.size() - 1))
            continue;
        dfs(nums, i + 1, length, end, hs);
        if (hs.size() != 0) { //(2)
            hs.remove(hs.get(hs.size() - 1));
            length--;
        }
    }
}