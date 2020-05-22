Greeter greetsJohn = new Greeter( "John Smith" );
Greeter greetsJane = new Greeter( "Jane Doe" );
System.out.println( greetsJohn.sayHello() );
System.out.println( greetsJane.sayHello() );
greetsJohn.swapNames( greetsJane );
System.out.println( greetsJohn.sayHello() );
System.out.println( greetsJane.sayHello() );