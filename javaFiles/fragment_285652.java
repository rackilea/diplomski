int taken = -1;
while(...){ // continue game
    switch(input){
    case "1":
        if( taken == -1 ) taken = rand.nextInt(mutation);
        if(taken < 10 ){
            ...
        }
        ...
        break;
    case "2":
        ...
        // Does healing happen here?
        taken = -1; // return to initial state
        break;
    case "3":
        ...
        break;
    }
}