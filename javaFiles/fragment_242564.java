class Solution {
public int solution(int[] A) {
    // write your code in Java SE 8
    int totalSum = 0;
    int firstSum = A[0];
    for(int i=1;i<A.length;i++)
     totalSum += A[i]; 

    int min = Math.abs(firstSum-totalSum);

    for(int i=1;i<A.length-1;i++) {
        firstSum+=A[i];
        totalSum-=A[i];
        if(Math.abs(firstSum-totalSum)<min) 
            min = Math.abs(firstSum-totalSum);

    }
    return min;
}
}