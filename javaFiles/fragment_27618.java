public  AL()
{
    count = 0;
    data = (X[]) new Object[10];
}

public void add (X v)
{
    // resize backing array if necessary
    if (data.length == count)
    {
        X [] newdata = (X[]) new Object[data.length * 2];
        for (int i = 0; i < data.length;i++ )
        {
            newdata[i] = data [i];
        }
        data = newdata;
    }
    // add new element
    data[count] = v;
    count++;
}