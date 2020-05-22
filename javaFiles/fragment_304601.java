public String printDetails()
{
    String returnString = ""; //declaring a string to build upon to return once finished all conditions.

    if(title !=null)
    {
        returnString += "Title: " + title + " ";
    }
    else if(title == null || title.length() <= 3)
    {
        returnString += "Title: " + "invalid text ";
    }

    if(bookNumber >= 10000 && bookNumber <= 20000)
    {
        returnString += "ISBN: " + bookNumber + " ";
    }
    else if(bookNumber == 0)
    {
        returnString += "ISBN: " + "invalid number ";
    }

    if(lastName == null || firstName == null)
    {
        returnString += "Author: " + "invalid text ";                                
    }
    else if(firstName != null || lastName != null) // changed to not= null.
    {
        returnString += "Author: " + firstName + " " + lastName + " ";
    }

    if(yearPublished == 0 && monthPublished == 0)
    {
        returnString += "Published: " + "invalid number ";

    }
    else if(yearPublished != 0 && monthPublished != 0)
    {
        returnString += "Published: " + monthName + " " + yearPublished;
    }

    return returnString; // now after the string has been built, we will return it.
}