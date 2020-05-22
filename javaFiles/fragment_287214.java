PhoneEntry addEntry( String addName, String addNumber )
{
    boolean found = false;
    for ( int i = 0 ; i < phoneBook.length ; i++ )
    {
        if ( phoneBook[i].name == null )
        {
            phoneBook[i] = new PhoneEntry( addName, addNumber );   
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Phone book is full! Delete an entry first!");
    }
    return null; // I'm not sure what you wish to return here
}