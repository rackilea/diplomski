double fine = 0;

if(argMaterial instanceof BOOK)
{
    //calculate fine for book
    if(argIsNew == true)
    {
        if(diff > 21)
        {
            fine = 1 + .25*diff;
        }

    }
    else if(argIsNew == false)
    {
        if(diff > 28)
        {
            fine = .25 * diff;
        }
    }
}

else if(argMaterial instanceof DVD)
{
    //calculate fine for dvd
    if(argIsNew == true)
    {
        if(diff > 3)
        {
            fine = 5 + diff;
        }

    }
    else if(argIsNew == false)
    {
        if(diff > 7)
        {
            fine = diff;
        }
    }

}
    return fine;