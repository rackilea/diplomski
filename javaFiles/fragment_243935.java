public void doSomething() 
{
    Operation op;
    while( null != (op=queue.poll()) )
        process( op );
}