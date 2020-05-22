Thread foo = new Thread(/*...*/);
foo.start();

//...

if (foo.isInterrupted()) 
{
   //do something
}