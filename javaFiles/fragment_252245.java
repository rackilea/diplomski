TiledMap aMap = new TiledMap("whatever.tmx");
int objectGroupCount = aMap.getObjectGroupCount();
for( int gi; gi < objectGroupCount; gi++ ) // gi = object group index
{
    int objectCount = aMap.getObjectCount(gi);
    for( int oi; oi < objectCount; oi++ ) // oi = object index
    {
        System.out.println( aMap.getObjectName(gi, oi) );
        System.out.println( aMap.getObjectProperty(gi, oi, "somepropertyname", "" ) );
    }
}