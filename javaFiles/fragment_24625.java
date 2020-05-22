int[] setA = {1,2,3,4};
int[] setB = {3 ,4, 5, 6 ,7};
int count=0;
System.out.print("The difference of sets A and B are: \n");
for (int i = 0; i < setA.length; i++) {
    count=0;
    for (int j = 0; j < setB.length ; j++) {
        if ((setA[i] != setB[j])){ 
            count++;

        } 
        if(count==setB.length){
            System.out.println(setA[i]);
        }
    }
}