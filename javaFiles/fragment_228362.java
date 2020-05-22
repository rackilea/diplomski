String sequence = "People,Object,Environment,Message,Service";

Map<String, String> lhm = new TreeMap<String, String>();
lhm.put( "Objectabc", "biu" );
lhm.put( "Message someText", "nuios" );
lhm.put( "Servicexyxyx", "sdfe" );
lhm.put( "People bcda", "dfdfh" );
lhm.put( "Environment qwer", "qwe" );
lhm.put( "Other", "names" );
lhm.put( "Elements", "ioup" );
lhm.put( "Rand", "uiy" );

for( String element : sequence.split( "," ) )
{
  final String elem = element;

  //try to get the value and remove it in one step
  String value = lhm.remove( new Comparable<String>()
  {
    public int compareTo( String other )
    {
      if( other.contains( elem ) )
      {
        return 0;
      }

      return elem.compareTo( other );
    }
  } );

  if( value != null )
  {
    System.out.println("values according with the sequence (key:" + element + ") is " + value); 
  }
}

for( Map.Entry<String, String> e : lhm.entrySet())
{
  System.out.println("non equal elements are " + e.getKey() + " (value: " + e.getValue() + ")");
}