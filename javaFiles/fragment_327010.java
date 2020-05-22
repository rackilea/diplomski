File file = new File("rebricek.txt");

if(file.exist())
{
    Scanner s = new Scanner(file);
    .
    .
    .
}
else
{
    System.out.println("The file does note exist!");
}