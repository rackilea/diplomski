int numbOfDoor = 0;
while(numbOfDoor != 2 && numbOfDoor != 4){
    numbOfDoor = scanDoor.nextInt();
    if(numbOfDoor == 4){
         System.out.println("Okay, so you want " + numbOfDoor);
    } else if(numbOfDoor == 2){
        System.out.println("Okay, so you want " + numbOfDoor);    
    } else{
        System.out.println("Select either 2 or 4 doors!");
    }
}