public void append(Book x)
{
    Book[] vAppend = new Book[v.length + 1];

    for (int i = 0; i < v.length; i++)
    {
        // ERROR: v.length is 3 but 
        // v[0], v[1], and v[2] will be null initially!!
        vAppend[i] = new Book(v[i]);
    }
    vAppend[v.length] = new Book(x);
    v = vAppend;
}