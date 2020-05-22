Random r=new Random();
int newNumber;
int oldNumber = -1; //Will never be matching the random number.
for(int i=0;i<100;i++){
    do{
        newNumber = r.nextInt(1000);
    } while (newNumber == oldNumber);
    System.out.println(newNumber));
    oldNumber = newNumber; 
}