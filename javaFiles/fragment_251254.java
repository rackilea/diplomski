if(sportArr[count] instanceof Footballer)
{
    Footballer fb = (Footballer) sportArr[count];

    // Now this should work (note the use of fb, and not using `==` with string literals):
    if(fb.getPos().equals("front")) { 
        // etc..
    }
}