// Licensed Apache2 (http://www.apache.org/licenses/LICENSE-2.0.txt) 
  import java.util.List;

  import java.net.URL;
  import java.net.URLConnection;

  import java.util.Map;
  import java.util.ArrayList;
  import java.util.LinkedHashMap;
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  /**
   * <pre>
   *    StringTemplate t = new StringTemplate("/catalog/{categoryId}/products/{productId}/summary");
   *    t.matches("/catalog/23/products/12375/summary"); // returns true
   *    t.match("/catalog/23/products/12375/summary");   // returns a map {categoryId=23, productId=12375}
   * </pre>
   * 
   * @author anaik
   */
  public class StringTemplate {
     /** The meta pattern for  template to match sequence such as: {someVar} */
     private static final Pattern patternPattern = Pattern.compile("\\{([^\\{\\}]+)\\}");
     /** The  pattern string */
     private String stringPattern;
     /** The generated pattern when the stringPattern is parsed */
     private Pattern thisStringPattern;
     /** Variable names found in this pattern in that order */
     private List<String> vars = new ArrayList<String>();

     /**
      * Creates a new StringTemplate from the specified pattern
      * @param Pattern
      */
     private StringTemplate(String stringPattern)  {
        this.stringPattern = stringPattern;
        initialize();
     }

     /**
      * Gets the names of variables - those defined in {variable-name} constructs - in this StringTemplate
      * in the order they were specified
      * @return a list of variables or an empty list if no variables were found
      */
     public List<String> getVars() {
        return vars;
     }

     /**
      * Determine whether the specified <tt>actualString</code> matches with this StringTemplate
      * @param actualString The actual  to match
      * @return true iff successfull match
      */
     public boolean matches(String actualString)  {
        return thisStringPattern.matcher(actualString).matches();
     }

     /**
      * Matches the <tt>actualString</tt> with this StringTemplate and extracts values for all the variables
      * in this template and returns them as an ordered map (keys defined in the same order as that of
      * the StringTemplate. If the match was unsuccessfull, an empty map is returned. Note that this method
      * should be ideally be called after {@link #matches(java.lang.String) } to check whether the 
      * specified actually matches the template
      */
     public Map<String, String> match(String actualString) {
        Matcher m = thisStringPattern.matcher(actualString);
        Map<String, String> map = new LinkedHashMap<String, String>();
        if(m.matches())   {
           int gc = m.groupCount();
           for(int i = 0; i < gc; i++)   {
              int g = i + 1;
              map.put(vars.get(i), actualString.substring(m.start(g), m.end(g)));
           }
        }
        return map;
     }

     private void initialize()  {
        Matcher m = patternPattern.matcher(stringPattern);
        StringBuffer builder = new StringBuffer();

        while(m.find())   {
           String var = m.group(1);
           vars.add(var);
           m.appendReplacement(builder, "(.*)");
        }
        m.appendTail(builder);
        String genPattern = builder.toString();
        thisStringPattern = Pattern.compile(genPattern);
     }

     public static void main(String[] args) throws Throwable  {
        StringTemplate t = new StringTemplate(args[0]);
        System.out.println("Matches with actual Class Identifier: java.lang.String: " + t.matches(args[1]));
        System.out.println("Var values: " + t.match(args[1]));
     }
  }