File file = new File("surveys");
System.out.println("user.dir=" + System.getProperty("user.dir"));
System.out.println("file is at: " + file.getCanonicalPath());
String[] names = file.list();

for(String name : names)
{
    if (new File(file, name).isDirectory())
    {
        System.out.println(name);
    }
}