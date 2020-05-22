System.out.print("Inv/Mo.\tRate\tYears\tFuture Value\n");
 for (int j = 0; j < FutureValueArrayList.size(); j++)
 {
    String ArrayList = FutureValueArrayList.get(j);
    System.out.print(ArrayList + "\t");
    if((j+1)%4 == 0){
        System.out.println();
    }

 }
System.out.println();