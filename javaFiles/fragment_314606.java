import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Module1{
  public static void main(String[] asd){
  String sourcestring = "source string to match with pattern";
  Pattern re = Pattern.compile("^PING\\b # match ping
[^(]*\\(([^)]*)\\) # capture IP
\\s([^.]*)\\. # capture the bytes of data
.*?^(\\d+\\sbytes) # capture bytes
.*?icmp_seq=(\\d+) # capture icmp_seq
.*?ttl=(\\d+) # capture ttl
.*?time=(.*?ms) # capture time
.*?(\\d+)\\spackets\\stransmitted
.*?(\\d+)\\sreceived
.*?(\\d+%)\\spacket\\sloss
.*?time\\s(\\d+ms)
.*?=\\s([^\\/]*)\\/([^\\/]*)\\/([^\\/]*)\\/(.*?)\\sms


",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
  Matcher m = re.matcher(sourcestring);
  int mIdx = 0;
    while (m.find()){
      for( int groupIdx = 0; groupIdx < m.groupCount()+1; groupIdx++ ){
        System.out.println( "[" + mIdx + "][" + groupIdx + "] = " + m.group(groupIdx));
      }
      mIdx++;
    }
  }
}