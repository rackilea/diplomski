List<String> myPropKeys = new ArrayList<String>();
myPropKeys.add("key1");
myPropKeys.add("key2");
myPropKeys.add("key3");

String input1 = "key1=key1 value key2=key2 value_key3=something key3=key3_value";
String input2 = "key3=key3_value key1=key1 value key2=key2 value_key3=something";
String input3 = "key2=key2 value_key3=something key1=key1 value key3=key3_value";

Map<String, String> propMap = getPropValues(input1, myPropKeys);
propMap = getPropValues(input2, myPropKeys);
propMap = getPropValues(input3, myPropKeys);
System.out.println();



private static Map<String, String> getPropValues( String input, List<String> myPropKeys )
{
     Map<String, String> propValues = new HashMap<String, String>();

     StringTokenizer tokens = new StringTokenizer( input );
     List<String> propKeyList = new ArrayList<String>();
     while( tokens.hasMoreTokens() )
     {
         String token = tokens.nextToken();
         int equalsIndex = token.indexOf( "=" );
         if( equalsIndex != -1 )
         {
             String propertyToken = token.substring( 0, equalsIndex );
             if (myPropKeys.contains(propertyToken))
             {
                propKeyList.add( propertyToken );
             }

         }
      }

      StringBuilder sb = new StringBuilder();
      for ( String propKey : propKeyList )
      {
        sb.append( propKey + "=" );
        sb.append( "(.*)" );
      }

      Pattern p = Pattern.compile(sb.toString());
      Matcher m = p.matcher(input);

      List<String> values = new ArrayList<String>();
      if (m.find())
      {
        for ( int i = 1; i <= propKeyList.size(); i++ )
        {
            values.add(m.group(i));
        }

      }

      if ( propKeyList.size() == values.size() )
      {
        for ( int i = 0; i < propKeyList.size(); i++ )
        {
            propValues.put( propKeyList.get(i), values.get(i).trim() );
        }
      }

       return propValues;
}