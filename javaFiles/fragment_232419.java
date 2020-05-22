if ( sc.useDelimiter("(?=:28)").hasNext() )
{
  System.out.printf("%n%s%n",  sc.next() );
}
if ( sc.useDelimiter("(?<=</n0:message>)").hasNext() )
{
  System.out.printf("%n%s%n",  sc.next() );
}
if ( sc.useDelimiter("\\z").hasNext() )
{
  System.out.printf("%n%s%n",  sc.next() );
}