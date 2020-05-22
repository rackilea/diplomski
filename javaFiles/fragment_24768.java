int numbOfDoor = 0;
while( true ){
    numbOfDoor = scanDoor.nextInt();
    if(numbOfDoor == 4){
         System.out.println("Okay, so you want " + numbOfDoor);
         break;
    }
    // More if + println + break
}