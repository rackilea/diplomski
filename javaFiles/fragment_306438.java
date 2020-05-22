if(boom)
{
    t1 = Time.current();  //t1 is now the current time
    t2 = Time.current() + 30000L; //t2 is now the current time + 5 minutes
    if(t1 < t2) //Is t1 smaller then t2? Yes it is!
        MarkTarget(); //call the function
    //Anything else? no so we will have had 1 call to it
}