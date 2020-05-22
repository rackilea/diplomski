List<? extends Number> l = getReadOnly( "working", Number.class );

//won't compile since the compiler isn't sure about the type of the list
//in our case it would actually be a List<Integer> but the compiler doesn't know that
//and thus disallows adding to the list - which is good since we'd produce a bug here
l.add( new Double(0.5));

//this would compile due to the raw type, which essentially disables type checks here
//fortunately the compiler warns us not to do this or at least be very careful
((List)l).add( new Double(0.5));