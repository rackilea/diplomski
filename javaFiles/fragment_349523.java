class TableStructure<Tuple>
{
    List<Tuple> tuples;
    Iterator iterator;

    public Tuple next() 
    {
        if ( iterator == null ) { iterator = tuples.iterator(); /* NPE prone */ }
        return iterator.next()
    }
}