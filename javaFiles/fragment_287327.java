public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);

        System.out.println("Now, give me a seven letter word: ");
        String word2 = kb.nextLine();
        word2 = word2.toUpperCase();
        System.out.println("I shout "+word2.toUpperCase()+ " when I’m excited, but I whisper "+ word2.toLowerCase() + " when I can't disturb the neighbours!");

        char e1;

        System.out.println("The word jumbled is: ");

        for(int i = 0; i < word2.length(); i++)
        {
            e1 = word2.charAt(i);
            if(i % 2 == 0)
            {
                System.out.print("" + Character.toUpperCase(e1));
            }
            else
            {
                System.out.print("" + Character.toLowerCase(e1));
            }
        }

        kb.close();
    }