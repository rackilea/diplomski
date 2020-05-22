@Override
public String toString()
{
    String nameString = null;

    if (Strings.isNullOrEmpty(middleName))
    {
        nameString = getFirstName() + " " + getLastName();
    }
    else
    {
        nameString = getFirstName() + " " + getMiddleName() + " " + getLastName();
    }

    return nameString;
}