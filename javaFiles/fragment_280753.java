public int compareTo(Object o)
{
    if ((o != null ) && (o instanceof CarOwner))
    {
        CarOwner otherOwner = (CarOwner) o;
        if (otherOwner.getYear() > getYear())
            return -1
         else if (otherOwner.getYear() < getYear())
             return 1
         else if  (otherOwner.getMonth() > getMonth())
             return -1
         else if  (otherOwner.getMonth() < getMonth())
             return 1;
         else 
             return 0;
    }
    return -1;
}