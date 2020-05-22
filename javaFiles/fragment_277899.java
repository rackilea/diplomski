Scanner S=new Scanner(System.in);
    int[] arr1=new int [6];
    for (int i = 0; i < 6; ++i) {
       int g = S.nextInt();
       arr1[i] = g;
    }
    S.close();
    int t = 0;
    int count = 0;
    int input=arr1.length;

    for(int j=0;j<input;j++){
        int temp=arr1[j];    
        int tempco=0;
        for(int p=0;p<input;p++){   
            if(arr1[p]==temp)
                tempco++;
            if(tempco>count){
                t=temp;
                count=tempco; 
            }
        } 
    }
    System.out.println("the most frequent number is "+String.valueOf(t)+"with "+String.valueOf(count)+" occurrences");