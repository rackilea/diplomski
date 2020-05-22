public short getFormat( String format )
{
    ListIterator i;
    int ind;
    if (format.toUpperCase().equals("TEXT")) 
            format = "@";
      if ( !movedBuiltins )
      {
        i = builtinFormats.listIterator();
        while ( i.hasNext() )
        {
            ind = i.nextIndex();
            if ( formats.size() < ind + 1 )
            {
                formats.setSize( ind + 1 );
            }
            formats.set( ind, i.next() );
        }
        movedBuiltins = true;
    }
    i = formats.listIterator();
    while ( i.hasNext() )
    {
        ind = i.nextIndex();
        if ( format.equals( i.next() ) )
            return (short) ind;
    }
    ind = workbook.getFormat( format, true );
    if ( formats.size() <= ind )
        formats.setSize( ind + 1 );
    formats.set( ind, format );
    return (short) ind;
}