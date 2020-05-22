InvocationRequest request = new DefaultInvocationRequest();
request.setPomFile( new File( "/path/to/pom.xml" ) );
request.setGoals( Collections.singletonList( "exec:java -DmainClass=com.vgrazi.MyClass -Dparam1=value1" ) );

Invoker invoker = new DefaultInvoker();
invoker.execute( request );