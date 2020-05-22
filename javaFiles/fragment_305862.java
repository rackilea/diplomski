class Check
{
static String s[] = { "q","w","e","r","t","y","u","i","o","p","a",
               "mmmmm","d","f","g","h","j","k","l","z","x","c","v" };

static String s1[] = {"b","n","m","er","re","ew","j","k","x","qq","ww","ee","c","v","t","y","d","f","g","h",
               "u","rr","yyy","uuu","ttt","trew","rerer","q","w","vv","gg","hh","tt","tr","ww","e","i"
               ,"eww","qwe","wer","o","p","a","s","ds","cv","r","l","z"};

public static void main(String arags[])
{
   Set<String> originalset = new HashSet<String>(Arrays.asList(s1));
   Set<String> testset = new HashSet<String>(Arrays.asList(s));        
   originalset.retainAll(testset);
    if(originalset.size()==23)
    {
        System.out.println("Sucess 23 matches found");
    }
    else
    {
          System.out.println("Fail 23 matches not found");
    }

}
}