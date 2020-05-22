class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++){
            if (!set.add(A[i])) { // add will return false if A[i] is already in the Set,
                                 // in which case we know we found a pair of equal numbers,
                                 // so we remove that number
                set.remove(A[i]);
            }
        }
        return set.iterator().next(); // according to the problem description, there should 
                                      // be exactly one element left
    }
}