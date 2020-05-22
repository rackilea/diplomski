int half = Math.floor(array/2);
int numberOfElementsInArray = array[0].length;
String [][] A = new String[half][numberOfElementsInArray];
String [][] B = new String[array.length - half][numberOfElementsInArray];
for(int i = 0; i < array.length; i++)
{
    if(i < half)
    {
        A[i] = array[i];
    }
    else
    {
        B[i] = array[i];
    }

}