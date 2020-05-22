public int compareTo (Object arg)
{
    if (salary > ((Employee)arg).salary)
        return 1;
    else if (salary == ((Employee)arg).salary)
        return 0:
    else 
        return -1;
}