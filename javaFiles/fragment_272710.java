public static void main(String[] args)
{       
    String text = "the quick brown fox jumps fox fox over the lazy dog brown";
    String[] textArray = text.split(" ");
    String[] keysToSearch = {"the", "fox", "dog"};
    int count = 0;
    System.out.println(text);

    for(String key: keysToSearch)
    {                       
        for(String s : textArray)
        {
            if(key.equals(s))
            {
                count++;
            }               
        }
        System.out.println("Count of ["+key+"] is : "+count);
        count=0;
    }
}