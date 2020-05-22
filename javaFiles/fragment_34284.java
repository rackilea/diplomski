public class Solution {
    public int jump(int[] A) {
        if (A.length <= 1)
            return 0;
        int maxReach = A[0];
        int step = A[0];
        int jump = 1;
        for (int i = 1; i < A.length; i++) {
           if (i == A.length - 1)
                return jump;
            if (i + A[i] > maxReach)
                maxReach = i + A[i];
            step--;
            if (step == 0) {
                jump++;
                step = maxReach - i;
            } 
        }
        return jump;
    }
}