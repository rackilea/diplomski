int max = 0;
int min = 101;
for(int i = 1; i<=counter ;i++){          
    inputNum = NumScanner.nextInt();
    if(inputNum > max){
        max = inputNum;
    }
    if(inputNum < min){
        min = inputNum;
    }
    if(inputNum > -1 && inputNum < 101){
        sum = sum + inputNum;
    }
    else{
        System.out.println("You entered a number that wasn't in the range of 0 to 100");
    }
}

 average = sum / counter;
 System.out.println("The average of the " + counter + " numbers you entered is " + average);