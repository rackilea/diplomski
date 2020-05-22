public static void main(String[] args)
{
    arrayConvert array_convert = new arrayConvert();
    int[] intArray = array_convert.StrArrtoIntArr(args);
    array_convert.displayArray(intArray);
}