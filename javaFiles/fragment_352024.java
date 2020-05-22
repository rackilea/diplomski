public String covertString(String inputStr, String strFormat)
{
    final char[] array = strFormat.toCharArray(); // dups the content
    int inputIndex = 0;

    for (int index = 0; index < array.length; index++)
        if (array[index] == 'x')
            array[index] = inputStr.charAt(inputIndex++);

    return new String(array);
}