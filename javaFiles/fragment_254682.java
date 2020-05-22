import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

class Test
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Pattern p = Pattern.compile("YOUR SET ADDRESS IS\\s+([A-Z0-9]{6})");
    Matcher n = p.matcher("YOUR SET ADDRESS IS 123456 FOO");
    if (n.find()) {
      System.out.println(n.group(1)); // Prints 123456
    }
  }
}