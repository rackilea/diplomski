int[] input = {1,2,3,4,5,6,7,8,9};

for(int i = 0; i < input.length; i++)
    if(input[i]==6 || input[i]==7)
        input[i]*=10;

  //Printing

for(int i : input)
   System.out.println(i);