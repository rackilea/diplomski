100000 runs of writeObject: 464
100000 runs of writeUnshared: 5082
100000 runs of writeUTF: 7541

import java.io.*;

public class WriteString
{
    private static int RUNS = 100000;

    private static int STR_MULTIPLIER = 100;

    public static void main(String[] a) throws Throwable
    {
        StringBuilder builder = new StringBuilder(26 * STR_MULTIPLIER);
        for(int i = 0; i < STR_MULTIPLIER; i++)
        {
            builder.append("abcdefghijklmnopqrstuvwxyz");
        }
        String str = builder.toString();

        File f = new File("oos");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));

        long startObject = System.currentTimeMillis();
        for(int i = 0; i < RUNS; i++)
        {
            oos.writeObject(str);
            oos.flush();
        }
        long endObject = System.currentTimeMillis();
        System.out.println(RUNS + " runs of writeObject: " + (endObject - startObject));

        long startUnshared = System.currentTimeMillis();
        for(int i = 0; i < RUNS; i++)
        {
            oos.writeUnshared(str);
            oos.flush();
        }
        long endUnshared = System.currentTimeMillis();
        System.out.println(RUNS + " runs of writeUnshared: " + (endUnshared - startUnshared));


        long startUTF = System.currentTimeMillis();
        for(int i = 0; i < RUNS; i++)
        {
            oos.writeUTF(str);
            oos.flush();
        }
        long endUTF = System.currentTimeMillis();
        System.out.println(RUNS + " runs of writeUTF: " + (endUTF - startUTF));

        oos.close();
        f.delete();

    }
}