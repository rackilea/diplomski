class Table<T extends Record>
{
    T rec;

    void set( T rec )
    {
        this.rec = rec;
    }

    void printAll()
    {
       rec.print(); 
    }
}