int sumOne = 0;
int sumTwo = 0;

for(int i = 0; i < a1.length; i++){
    sumOne += a1[i];
    if(i < a2.length)
        sumTwo += a2[i];
}

int missingNumber = sumOne - sumTwo;