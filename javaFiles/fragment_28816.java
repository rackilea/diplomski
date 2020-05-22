Class cl = // initialize somehow
// get all constructors for class
Constructor[] constructors = cl.getConstructors(); 

 // for each constructor
for(Constructor c : constructors)
{
     // if there is a zero-parameter constructor
    if(c.getParameterTypes().length == 0)
    {
        // then we can safely create a constructor for it
        cl.newInstance(); 
    }
}