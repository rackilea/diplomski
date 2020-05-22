private Integer getIntegerDependingOnFlag(boolean flag)
{
    if (flag)
        return new Integer(MANIPULATED_VALUE);
    else
        return new Integer(NON-MANIPULATED_VALUE);
}