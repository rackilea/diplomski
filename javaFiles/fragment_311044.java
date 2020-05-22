long totSum = 0;
for(int i=0; i<arr.length; i++){
    totSum += arr[i];
}

long sumOne = totSum - arr[0];
long sumTwo = totSum - arr[1];
long sumThree = totSum - arr[2];
long sumFour = totSum - arr[3];
long sumFive = totSum - arr[4];

long[] num = {sumOne, sumTwo, sumThree, sumFour, sumFive};
long temp = 0;
for(int i=0;i<num.length;i++){
    for(int j=1;j<(num.length-i);j++){
        if(num[j-1] > num[j]){
            //swap elements
            temp = num[j-1];
            num[j-1] = num[j];
            num[j] = temp;
        }
    }
}

System.out.print(num[0] + " " + num[4]);