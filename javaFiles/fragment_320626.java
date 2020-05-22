int size = 0;
while (size < data.length)
{
    if (data[size] == 0)
    {
        break;
    }
    size++;
}

// Specify the appropriate encoding as the last argument
String myString = new String(data, 0, size, "UTF-8");