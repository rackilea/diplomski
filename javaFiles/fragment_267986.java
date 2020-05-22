import java.util.regex.Pattern;
public class example {
  public static void main(String[] asd){
  String sourcestring = "\"aaa\"    123 \"bbb\" \"cc\"  \"ddd\"\n"
             + "\"aaa\" 123 \"bbb\" \"cc\"  \"  6\"\n"
             + "\"ddd\" 456 \"eee\" \"ff\"  \"          \"\"     \"\n"
             + "\"ddd\" 456 \"eee\" \"ff\"  \"  \"\" aaa \"\"   \"";
  Pattern reLines = Pattern.compile("\\n");          
  Pattern reTsv = Pattern.compile("\\t(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
  String[] lines = reLines.split(sourcestring);
  for(int linesIdx = 0; linesIdx < lines.length; linesIdx++ ) {
    String[] parts = reTsv.split(lines[linesIdx]);
    for(int partsIdx = 0; partsIdx < parts.length; partsIdx++ ) {
        System.out.println( "[" + partsIdx + "] = " + parts[partsIdx]);
      }
    }
  }
}