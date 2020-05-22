for(int i = 3; i < arr.length; i += 4) // i is pointing at the end of each quadruple, so it will never show an incomplete one
{
    arr2[i-3] = arr[i-2];
    arr2[i-2] = arr[i-1];
    arr2[i-1] = arr[i];
    arr2[i] = arr[i-3];
}

int nbRemainingElements = arr.length % 4;
for(int i = 0; i < nbRemainingElements; ++i)
{
    int index = arr.length - i - 1;
    arr2[index] = arr[index];
}