/**
 * Convert name from string into 8 bytes truncating and padding with spaces
 * id necessary.
 */
public static byte [] truncateName (String name)
{
    byte [] result = new byte [8];
    for (int i = 0; i < 8; i++)
        result [i] = i < name.length () ? (byte)name.charAt (i) : (byte)' ';
    return result;
}

/**
 * Convert double value into 8 bytes.
 */
public static byte [] packAmount (double amount)
{
    byte [] result = new byte [8];
    long bits = Double.doubleToLongBits (amount);

    for (int i = 0; i < 8; i++)
    {
        result [i] = (byte)(bits & 0xFF);
        bits >>>= 8;
    }

    return result;
}

public static void writeAccountinformation (
    RandomAccessFile file, int account, String name, double amount)
    throws IOException
{
    file.seek (account * 16); // 8 bytes for name and another 8 for amount
    file.write (truncateName (name));
    file.write (packAmount (amount));
}

public static void main(String[] args) throws Exception
{
    RandomAccessFile file = new RandomAccessFile ("bank.txt", "rw");
    try
    {
        BufferedReader reader = new BufferedReader (
            new InputStreamReader (System.in));

        while (true)
        {
            System.out.print ("Enter Account Number (0-9999): ");
            int account = Integer.parseInt (reader.readLine ());
            System.out.print ("Enter Last Name: ");
            String name = reader.readLine ();
            System.out.print ("Enter Balance: ");
            double amount = Double.parseDouble (reader.readLine ());

            writeAccountinformation (file, account, name, amount);

            System.out.println ("Enter More? (y/n)");
            if (reader.readLine ().toLowerCase ().equals ("n"))
                break;
        }
    }
    finally
    {
        file.close();
    }
}