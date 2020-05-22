public static void main(String[] args)
    {
        String line, word;
        Scanner in =  new Scanner(System.in);
        System.out.println("Enter the line");
        line = in.nextLine();
        System.out.println("Enter the word to remove from line");
        word = in.nextLine();
        Boolean found = Arrays.asList(line.split(" ")).contains(word);
        if(found)
        {
            line = line.replace(word, "");
        }
        System.out.println("The line after remove the word is:\n "+line);
        char[] check = line.toCharArray();