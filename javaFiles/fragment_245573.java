// a variable that persists across function calls such as an instance field
int[] array = new int[20];    // just giving some extra memory in case you want to calculate other members
array[0] = -1;      //invalid member of the sequence since it is 1-based
array[1] = 3;
array[2] = 3;

//set the rest of the numbers to values letting you know they have not been set/found/calculated yet
for (int i = 3; i < 20; i++)
{
    array[i] = -1;
}

// index is the member number; it is 1 based e.g. index of 1 gives the first number in the sequence
int find(int index)
{
    if (array[index] != -1)   //if already calculated that member, just return it
        return array[index];

    //store the answer
    array[index] = (find(index - 1) * find(index - 2)) - find(2);
    return array[index];
}