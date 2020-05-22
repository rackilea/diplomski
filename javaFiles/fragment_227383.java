int[] input = {0,1,2,3,4,5};

int max = input[0];
int min = input[0];
int sum = 0;

for(int i : input){
    sum += i;
    if(i < min){
        min = i;
    }else if(i > max){
        max = i;
    }
}

System.out.println("sum for input is : " + sum);
System.out.println("highest value element is : " + max);
System.out.println("lowest value element is : " + min);
System.out.println("sum excluding extreme elements is : " + (sum - min -max));

// have cast the result as a float as i dont know if average should be truncated or not
System.out.println("average excluding extreme elements is : " + ((float)(sum - min -max)/(input.length-2)));