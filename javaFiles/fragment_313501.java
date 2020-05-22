int num=6789123,lastvalue=0;
    int largest = 0;
    int secondLargest = 0;
    while(num>0){

        int reminder=num%10;
        if(reminder > largest)          //get the largest number
        {
            largest = reminder;
        }

        System.out.println(reminder);
         lastvalue=lastvalue*10+reminder;
         num/=10;
    }

    num=6789123;
    while(num>0){
        int reminder=num%10;
        if(reminder > secondLargest)    //get the second largest number
        {
            if(reminder != largest)
            {
                secondLargest = reminder;
            }
        }
         lastvalue=lastvalue*10+reminder;
         num/=10;
    }


    System.out.println(largest);
    System.out.println(secondLargest);