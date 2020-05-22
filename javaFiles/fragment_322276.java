FileInputStream input = new FileInputStream ("bank.txt");
try
{
    byte [] record = new byte [16];
    while (input.read (record) == 16)
    {
        String name = new String (record, 0, 8);
        long bits = 0L;
        for (int i = 15; i >= 8; i--)
        {
            bits <<= 8;
            bits |= record [i] & 0xFF;
        }
        double amount = Double.longBitsToDouble (bits);

        System.out.println("Name: " + name + ", amount: " + amount);
    }
}
finally
{
    input.close ();
}