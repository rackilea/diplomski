@Override
public String toString()
{
    if(middleName == null)
    {return  getFirstName() + " " + getLastName();}
    else
    {return  getFirstName() + " " + getMiddleName() + " " + getLastName();}
}