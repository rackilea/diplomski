import java.util.HashMap;
import java.util.Map;

public class TokenSizes {

    Map<Integer, Integer> tokenSizes = new HashMap<>();

    public void processToken(String token){
        Integer len = token.length();
        if(tokenSizes.containsKey(len)){
            tokenSizes.put(len, tokenSizes.get(len) + 1);
        }
        else{
            tokenSizes.put(len, 1);
        }
    }

    public void printTokenSizes(){
        System.out.println("Token Sizes:\n" + tokenSizes);
    }

    public static void main(String[] args) {
        TokenSizes ts = new TokenSizes();
        ts.processToken("hi");
        ts.processToken("to");
        ts.processToken("say");

        ts.printTokenSizes();
    }
}