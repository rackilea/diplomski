public class ParseAdd implements Fn<String, Cmd<Integer>> { 
     public Cmd<Integer> apply(String option) {
       // parse the input and return the command with the arguments in there 
       // if (option == "add"  and args exist )
       // try parse args
       // i = Integer.parse(substring);

       return new Add(i); 
     }
 }