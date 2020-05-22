public E root() throws Exception 
{
    if (isEmpty())
        throw new Exception ();
    return this.root();
}