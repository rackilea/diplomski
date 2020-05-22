public int compareTo(Object o)
{
    if ((o != null ) && (o instanceof CarOwner))
    {
        CarOwner otherOwner = (CarOwner) o;
        int result = otherOwner.getYear().compareTo(getYear());
        if (result != 0)
            return result;
        return otherOwner.getMonth().compareTo(getMonth());
    }
    return -1;
}