z = -1;

if(z < 0) //TRUE
    z += 3; //which means (z += 3) = 2
else if(z == 2) //Wont trigger
    z += 5;
if(z < 5) //TRUE
    z *= 15; //which means (z *= 15) ==  (z = 2 * 15) == 30 
System.out.println("z is  = " + z);