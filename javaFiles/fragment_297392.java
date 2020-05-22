//works because the type is Integer for the list and the class
put( "working", new ArrayList<Integer>(), Integer.class ); 

//doesn't work since Number != Integer, even though Integer extends Number
put( "error", new ArrayList<Number>(), Integer.class );
put( "still an error", new ArrayList<Integer>(), Number.class );

//careful, this compiles because the raw type List is used
//the compiler would warn us though, so don't take those warnings lightly :)
put( "raw", (List)new ArrayList<Number>(), Integer.class );