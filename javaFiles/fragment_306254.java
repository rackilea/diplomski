Scanner scanner=null;
try
{
    scanner = new Scanner(new File(path));
    //your code here
}
catch(FileNotFoundException e)//either catch or throw out
{
   //log it
}
finally
{
    if(null !=scanner)
    {
        scanner.close();
    }
 }