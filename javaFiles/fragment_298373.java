ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("myfile.txt");
Object obj = objIn.readObject();
if(obj instanceof Shoe)
{
    Shoe shoe = (Shoe)obj;
}