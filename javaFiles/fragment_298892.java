function solution(V) {

    var sum = 0;
    for (i=0; i < V.length; i++) {
      sum += V[i];   
    }

    var leftSum= 0;
    var rightSum = 0;

    for (j=0; j < V.length; j++) {
      rightSum = sum - (leftSum + V[j]);
      if(leftSum == rightSum) {
          return j;
      }
      leftSum += V[j];
    }
    return -1;
}