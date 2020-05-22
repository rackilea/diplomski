if (e.getActionCommand().equals("q2"))
{
    {   // this block is unnecessary
    // bunch of stuff in here
    }

    //  this block is buried within the if block above, and so will never be true
    if (e.getActionCommand().equals("q3"))
    {
        { // again this block is unnesseary
        // more bunch of code
        }

        // again this block is buried within the previous two!
        if (e.getActionCommand().equals("end"))
        {