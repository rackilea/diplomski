public static void main(String[] args) {
    String input = "Now is the time for all great men to come to the aid of their country";
    String tempString = "";
    char c = '\0';
    int n = input.length();
    for(int i = 0; i<n; i++)
    {
        c = input.charAt(i); // this needs to be outside the if statement
        if(c != ' ')
        {
            tempString = tempString + c;
        }
        else
        {
            System.out.println(tempString);
            tempString = "";
        }
    }
}