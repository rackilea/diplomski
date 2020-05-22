boolean keepGoing = true;
while (keepGoing){
    //print out the options
    int slct = reader.nextInt(); //get input
    switch(slct){
        case 1:
            //user inputted 1
            break; //otherwise you will fall through to the other cases
        case 2:
            //...
            break;
        case 3:
            //...
            break;
        case 4: //or other number to quit, otherwise this will repeat forever
            keepGoing = false; //stop the loop from repeating again
            break;
    }
}