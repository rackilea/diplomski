for(int i = 3; i < arr.length; i += 4) // i is pointing at the end of each quadruple, so it will never show an incomplete one
{
    T firstQuadElement = arr[i-3];
    arr[i-3] = arr[i-2];
    arr[i-2] = arr[i-1];
    arr[i-1] = arr[i];
    arr[i] = firstQuadElement;
}