package org.test.stackoverflow;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternReplacer {
  private final Pattern keyPattern = Pattern.compile("%([^%]*)%");
  private final Properties properties;

  public PatternReplacer(Properties propertySeed) {
    properties = propertySeed;
  }

  public String replace(String input) {
    int start = 0;

    while(true) {
      Matcher match = keyPattern.matcher(input);

      if(!match.find(start)) break;

      String group = match.group(1);
      if(properties.containsKey(group)) {
        input = input.replaceAll("%" + group + "%", properties.getProperty(group));
      } else {
        start = match.start() + group.length();
      }
    }

    return input;
  }

  public static void main(String... args) {
    Properties p = new Properties();
    p.put("animal1", "cat");
    p.put("animal2", "dog");

    PatternReplacer test = new PatternReplacer(p);
    String result = test.replace("foo %animal1% %bar% %animal2%baz %animal1% qu%ux");
    System.out.println(result);
  }
}