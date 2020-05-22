JDC: Why is Throwable not an interface? The name kind of suggests it should have been.  
Being able to catch for types, that is, something like try{}catch (<some interface or 
class>), instead of only classes. That would make [the] Java [programming language] 
much more flexible.

JG: The reason that the Throwable and the rest of those guys are not interfaces is 
because we decided, or I decided fairly early on. I decided that I wanted to have some 
state associated with every exception that gets thrown. And you can't do that with 
interfaces; you can only do that with classes. The state that's there is basically 
standard. There's a message, there's a snapshot, stuff like that — that's always there.    
and also, if you make Throwable an interface the temptation is to assign, to make any 
old object be a Throwable thing. It feels stylistically that throwing general objects 
is probably a bad idea, that the things you want to throw really ought to be things 
that are intended to be exceptions that really capture the nature of the exception and 
what went on. They're not just general data structures.