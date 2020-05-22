public class TestCheckWord {
    static String words = "admin,administrator,babo,sir,melon";
    public static void main (String args[]){        
        System.out.println(checkWord("Hello melon"));
        System.out.println(checkWord("Hello sir"));
        System.out.println(checkWord("Hello you"));
    }
    public static boolean checkWord(String input) {
        String wordArray[] = words.split(",");
        for(int i=0; i<wordArray.length; i++){
            if(input.indexOf(wordArray[i])>-1)
                return true;            
        }
        return false;
    }
}