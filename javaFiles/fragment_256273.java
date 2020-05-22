public int operator this++()
{
    int temp = this;
    ++this; // regular pre-increment (JLS §15.15.1)
    return temp;
}