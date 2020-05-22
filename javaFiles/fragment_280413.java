package so_token;

import java.util.*;    

public class TokenMatcher {

    public TokenMatcher(List<String> tokenList) {
        this.tokenList = tokenList;
    }

    List<String> tokenList;

    List<String> findSentencesWith(String... tokens) {
        List<String> results = new ArrayList<String>();

        // start by assuming they're all good...
        results.addAll(tokenList);

        for (String str : tokenList) {
            for(String t : tokens) {
                // ... and remove it from the result set if we fail to find a token
                if (!str.contains(t)) {
                    results.remove(str);

                    // no point in continuing for this token
                    break;
                }
            }
        }

        return results;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        List<String> tokenList = new ArrayList<String>();
        tokenList.add("How now a1 cow.");
        tokenList.add("The b1 has oddly-shaped a2.");
        tokenList.add("I like a2! b2, b2, b2!");

        TokenMatcher matcher = new TokenMatcher(tokenList);

        List<String> results = matcher.findSentencesWith("a1");     // Returns 1 String ("How now a1 cow")

        for (String r : results) {
            System.out.println("1 - result: " + r);
        }

        List<String> results2 = matcher.findSentencesWith("b1");    // Returns 1 String ("The b1 has oddly-shaped a2.")

        for (String r : results2) {
            System.out.println("2 - result: " + r);
        }

        List<String> results3 = matcher.findSentencesWith("a2");    // Returns the 2 Strings with a2 in them since "a2" is all we care about...

        for (String r : results3) {
            System.out.println("3 - result: " + r);
        }       

        List<String> results4 = matcher.findSentencesWith("a2", "b2");  // Returns 1 String ("I like a2! b2, b2, b2!.") because we care about BOTH tokens

        for (String r : results4) {
            System.out.println("4 - result: " + r);
        }
    }
}