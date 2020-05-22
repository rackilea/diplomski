public static <T> void save(T t, String fileName)
{
        ObjectOutputStream out = 
                new ObjectOutputStream(
                        new FileOutputStream(fileName));
        out.writeObject(t);
        out.close();
}

public static <T> T load(String fileName)
{
    T object = null;

    ObjectInputStream in = 
            new ObjectInputStream(
                    new FileInputStream(fileName));
    object = (T)in.readObject();
    in.close();

    return (T)object;
}