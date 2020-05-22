class PigLatin
{
    String originalString = "", pigString = "";

    public void input() {
        System.out.println("Please enter your string.");
        System.out.print("String: ");
        originalString = keyboard.nextLine().toLowerCase();
    }

    private String pigLatinator(String word)
    {
        String output = "";
        int index = word.length() -1;
        char lastChar = word.charAt(index);

        if(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u"))
        {
            if (char == '.' || char == ',' || char == '!')
                output = word.substring(0,index) + "ay" + word.charAt(index);
            else
                output = word + "ay";
        }
        else
        {
            if (char == '.' || char == ',' || char == '!')
                output = word.substring(1,index) + word.charAt(0) + "ay" + word.charAt(index);
            else
                output = word.substring(1) + word.charAt(0) + "ay";
        }

        return output;
    }

    public void translate()
    {
        String[] words = originalString.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            pigString += pigLatinator(words[i]) + " ";
        }
    }

    public void display()
    {
        System.out.println();
        System.out.println("Original string: " +originalString);
        System.out.println("Translation: " +pigString);
    }
}