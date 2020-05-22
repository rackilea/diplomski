class Assets {
    public Integer kick = 5;
}

class HelloWorld
{
    public static void main (String[] args)
    {
        Assets t = new Assets();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field f: fields){
            System.out.println("f = " + f.getName()); // prints f = kick
        }
    }
}