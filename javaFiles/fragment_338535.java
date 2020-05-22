int oneSize = listOne.size();
int twoSize = listTwo.size();

for(int i = 0; i < oneSize; i++)
{
    if(i == oneSize || i == twoSize)
        return oneSize - twoSize;

    int elementOne = listOne.get(i);
    int elementTwo = listTwo.get(i);
    if(elementOne == elementTwo)
       continue;

    return Integer.compare(elementOne, elementTwo);
}