import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



class Main{

    public static List<String> expand(char c){
        switch(c){
            case 'S':
                return Arrays.asList(new String[]{"x", "LR", "LT"});
            case 'T':
                return Arrays.asList(new String[]{"SR"});
            case 'L':
                return Arrays.asList(new String[]{"("});
            case 'R':
                return Arrays.asList(new String[]{")"});
            default:
                throw new RuntimeException("Value not in language");
        }
    }

    public static Boolean isTerminal(char c){
        return c == 'x' || c == '(' || c == ')';
    }

    // For all expansions of c, prepend pre and append post
    public static List<String> expandInPlace(String pre, char c, String post){
        return expand(c).stream().map(str -> pre + str + post).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Value entered on command line is string to check
        String checkString = args[0];
        int iterations = 2 * checkString.length() - 1;

        // Start with root of language "S"
        List<String> rhs = Arrays.asList(new String[]{"S"});
        for(int i=0; i<iterations; i++){
            // nextRhs is new list created by expanding the current list along language rules
            List<String> nextRhs = new ArrayList<>();
            for(int j=0; j<rhs.size();  
                String pre = "";
                String post = rhs.get(j);
                for(int k=0; k<rhs.get(j).length();k++){
                    // Treating pre and post like a double stack
                    // Popping the next character off the front of post
                    char expansionChar = post.charAt(0);
                    post = post.substring(1);
                    if(!isTerminal(expansionChar)){
                        nextRhs.addAll(expandInPlace(pre, expansionChar, post));
                    }
                    pre += expansionChar;
                }
            }
            rhs = nextRhs;
            System.out.println(rhs);
            System.out.println();
        }

        if(rhs.contains(checkString)){
            System.out.println(checkString + " is in the language");
        } else {
            System.out.println(checkString + " is not in the language");
        }

    }
}