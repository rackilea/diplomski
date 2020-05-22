if (!left)
{
    if(!repeatLeftReleased) // no chance for `=` now!
    {
        System.out.println("Left mouse button released");
        repeatLeftReleased = true;
        repeatLeftPressed = false;
    }
    if(repeatLeftReleased) // this is always true here
    {   
        repeatLeftPressed = false;
    }
}