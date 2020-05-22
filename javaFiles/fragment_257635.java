int cheat = 0; //keeps track of how many were pressed in order

if (cheat == 0 && upButtonPressed)
    cheat++;
elseif (cheat == 1 && upButtonPressed)
    cheat++;
elseif(cheat == 2 &&  downButtonPressed)
    cheat++;
//rest of the order
else
    cheat = 0;

if (cheat == 8) //or however many buttons need to be pressed
    //do whatever you want to happen when the cheat is activated