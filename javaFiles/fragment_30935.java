String names[] = new String[x];
    Scanner reader = new Scanner(file);
    while (reader.hasNextLine())
    {
        names[x] = reader.nextLine();
        System.out.println(names[x]);
        x--;
    }