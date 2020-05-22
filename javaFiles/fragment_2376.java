double[] myList = {num1,num2,num3};
double temp;
for (int i = 1; i < myList.length; i++) {
   for(int j = i ; j > 0 ; j--){
      if(myList[j] < myList[j-1]){
         temp = myList[j];
         myList[j] = myList[j-1];
         myList[j-1] = temp;
      }
   }
}

//Output max
System.out.println("The maximum number of the three numbers is " + myList[2]);