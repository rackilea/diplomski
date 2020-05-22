// TODO seriously consider something else than Vector to store the rows and columns!
Map<String,Vector> map = new HashMap<String,Vector>()

while(rowIter.hasNext())
{
    boolean isFirst = false;
    String phoneModel = "";
    while( cellIter.hasNext() )
    {
        XSSFCell cell = (XSSFCell) cellIter.next();
        if ( isFirst ) { phoneModel = cell.getTheTextContentOrWhatever(); isFirst = false; }
        cellStoreVector.addElement(cell);
    }
    if ( map.get( phoneModel ) == null ) { map.put( phoneModel , new Vector() ); }
    map.get( phoneModel ).add( cellStoreVector );
}