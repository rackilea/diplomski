byte[] bs = "cm³".getBytes( "UTF-8" ); // byte[] bs = "cm\u00B3".getBytes( "UTF-8" );
for ( byte b : bs )
{
    System.out.println( b );
}

99
109
-62
-77