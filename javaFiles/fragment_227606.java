private Door pickADoor(){
    Random rand = new Random();
    int i = rand.nextInt(3);
    if (i == 2){
       return A;
    }else if (i == 1){
       return B;
    }else if (i == 0){
       return C;
    }else{
       return SOMETHING; //somthing here
    }