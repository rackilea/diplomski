File file = new File("C:\\Windows");
String[] names = file.list();

for(String name : names)
{
    if (new File("C:\\Windows\\" + name).isDirectory())
    {
        System.out.println(name);
    }
}