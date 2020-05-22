public int GetNumOfRightChildren()
{
    int Result = 0;
    if (null != root)
        Result = 1 + root.GetNumOfRightChildren();
    return Result;
}