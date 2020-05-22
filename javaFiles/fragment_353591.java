public static void main (String[] args) throws Exception
    {
        File f = new File("SaveFile");
        Scanner sc = new Scanner(f);
        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine())
        {
            builder.append(sc.nextLine() + "\n");
        }
        String save = builder.toString();
        FileWriter writer = new FileWriter(f);
        writer.write(save);
        writer.close();
    }