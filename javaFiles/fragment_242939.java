public int GetNumOfRightChildren()
{
    int Result = 0;
    if (null != right)
        Result = 1 + right.GetNumOfRightChildren();
    return Result;

}