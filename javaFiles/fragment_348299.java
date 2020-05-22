Boolean atFound = false;
Boolean periodFound = false;
Boolean spaceFound = false;
For (integer cnt = 0; cnt < email.length; cnt ++)
{
    If (email [cnt].compareTo ("@") == 0)
        atFound = true;
    If (email [cnt].compareTo (".") == 0)
        periodFound = true;
    If (email [cnt].compareTo (" ") == 0)
        spaceFound = true;
}