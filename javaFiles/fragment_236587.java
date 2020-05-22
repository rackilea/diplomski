SomeClass[] b = null;
try (
    ObjectInputStream inputStream =
        new ObjectInputStream(new FileInputStream("arrayfile"))) 
{
    b = (SomeClass []) inputStream.readObject();
}