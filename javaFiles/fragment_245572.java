// index is the member number; it is 1 based e.g. index of 1 gives the first number in the sequence
int find(int index)
{
    if (index == 1 || index == 2)
        return 3;

    return (find(index - 1) * find(index - 2)) - find(2);
}