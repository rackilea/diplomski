do
{
    String[] entry = new String[3];

    for (int i = 0; i < 3; i++)
    {
        if (opnEsoda.hasNextLine())
        {
            // Trim removes leading or trailing whitespace.
            entry[i] = opnEsoda.nextLine().trim(); 
        }
    }

    System.out.println(entry[2]);
}
while (opnEsoda.hasNextLine)