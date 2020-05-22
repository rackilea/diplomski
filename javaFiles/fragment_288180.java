public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j <  nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[k]);

                        Collections.sort(subList);
                        boolean duplicate = false;

                        for (List<Integer> list : result) {
                            if (list.equals(subList)) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (!duplicate) {                            
                            result.add(subList);
                        }   
                    }
                }
            }
        }

        return result;
    }
}