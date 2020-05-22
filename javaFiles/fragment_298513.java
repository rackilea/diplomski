// before
int x;
for (x = 0; x < doors.length - 1; x++)
{
    if ((x+1) % y == 0)
    {
        //code
    }
}

// after
for (int x = y - 1; x < doors.length - 1; x += y)
{
    //code
}