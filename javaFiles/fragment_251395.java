public static void main(String[] args) throws FileNotFoundException
    {
        @SuppressWarnings("resource")
        Scanner fileContent = new Scanner(new File("Users.txt"));
        Integer usernameHash = 42321;

        // Integer usernameHash = 42321;
        while (fileContent.hasNextLine())
        {

            String line = fileContent.nextLine();
            if (line.equals(usernameHash.toString()))
            {
                System.out.println("Match");
            }
        }
    }