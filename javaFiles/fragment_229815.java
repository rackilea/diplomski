package stackoverflow;

 import java.util.regex.Matcher;
 import java.util.regex.Pattern;

 import com.google.caliper.Param;
 import com.google.caliper.Runner;
 import com.google.caliper.SimpleBenchmark;
 import com.google.common.base.Splitter;
 import com.google.common.collect.Iterables;

 public class RegexPerformance extends SimpleBenchmark {
      private static final String firstPart    = "technology|computer|sdc|adj|wdc|pp|stub";
      private static final String secondPart   = "profile|preference|experience|behavioral";
      private static final String VALID_DOMAIN = "(technology|computer|sdc|adj|wdc|pp|stub)\\.(profile|preference|experience|behavioral)";

      @Param({"technology.profile.financial", "computer.preference.test","sdc.experience.test"})
      private String input;

      public static void main(String[] args) {
           Runner.main(RegexPerformance.class, args);
      }

      public void timeRegexMatch(int reps){
          for(int i=0;i<reps;++i){
              regexMatch(input);
          }
      }


      public void timeGuavaMatch(int reps){
          for(int i=0;i<reps;++i){
              guavaMatch(input);
          }
      }

      public void timeRegexMatchOutsideMethod(int reps){
          for(int i=0;i<reps;++i){
              regexMatchOutsideMethod(input);
          }
      }


    public String regexMatch(String input){
        Pattern p = Pattern.compile(VALID_DOMAIN);
        Matcher m = p.matcher(input);
        if(m.find()) return m.group();
        return null;
    }

    public String regexMatchOutsideMethod(String input){
          Matcher matcher = pattern.matcher(input);
          if(matcher.find()) return matcher.group();
          return null;
    }

    public String guavaMatch(String input){
        Iterable<String> tokens = Splitter.on(".").omitEmptyStrings().split(input);
        String firstToken  = Iterables.get(tokens, 0);
        String secondToken = Iterables.get(tokens, 1);
        if( (firstPart.contains(firstToken) ) && (secondPart.contains(secondToken)) ){
            return firstToken+"."+secondToken;
        }
        return null;
    }
}