int i=4;

int temp = i + i; // 8
i = i + 1;
i = temp;         // still 8

System.out.println("Output"+ i);        //8
System.out.println("Output Step 2"+ i); //8