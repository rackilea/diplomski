Employee emp = map.get( "someone@somedomain.com" );

if( emp != null )
    System.out.println( "Employee with that email address is " + emp );
else
    System.out.println( "No Employee with that email address." );