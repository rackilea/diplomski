private static File theFile = new File("theonetoopen.txt");
...

private void someImportantIOMethod(Object stuff){
    synchronized(theFile){

    //Your file output writing code here.

    }
}