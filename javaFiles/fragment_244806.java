import java.util.ArrayList;
import java.util.Arrays;


public class expSplit {

    public String[] splitExp(String theexp){
        ArrayList<String> tokens = new ArrayList<String>();
        //System.out.println(theexp);
        String expression = theexp.replaceAll("\\s+", "");
        //System.out.println(expression);
        String tem[] = expression.split("(?<=[-+*/%(),])(?=.)|(?<=.)(?=[-+*/%(),])");
        ArrayList<String> temp = new ArrayList<String>(Arrays.asList(tem));
        String orig = null;
        String regex = "[-+/%*]+";
        String first = temp.get(0);
        tokens.add(first);
        String secound = temp.get(1);
        if(first.equals("-")){
            tokens.remove(0);
            tokens.add(first+secound);
        }
        for (int i = 0; i < temp.size(); i++) {
            String a = temp.get(i);
            if (i >= 1){
                String b = temp.get(i-1);
                if(b.matches(regex) && a.matches("[-+]+")){
                    String c = temp.get(i-2);
                    if(c.matches("[-+]+")){
                        //System.out.println("MATCH");
                        break;
                    }else{
                        //System.out.println("NO MATCH");
                        orig = a;
                    }
                }else if(orig != null && orig.equals("-")){
                    tokens.add(orig + a);
                    orig = null;
                }else{
                    tokens.add(a);
                }
            }
        }
        if(first.equals("+")){
            tokens.remove(0);
        }
        if(first.equals("-")){
            tokens.remove(1);
        }
        String[]tokenArray = new String[tokens.size()];
        tokenArray = tokens.toArray(tokenArray);
        //System.out.print(tokens);
        return tokenArray;
    }
}