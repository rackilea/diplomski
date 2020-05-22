public class Main {
  public static void main(String[] args) {
    ResourceBundle labels = ResourceBundle.getBundle("spring-regex/regex-resources", Locale.UK);
    Enumeration<String> labelKeys = labels.getKeys();

    // Build up a buffer of label keys
    StringBuffer sb = new StringBuffer();
    while (labelKeys.hasMoreElements()) {
      String key = labelKeys.nextElement();
      sb.append(key + "|");
    }

    // Choose the pattern for matching
    Pattern pattern = Pattern.compile(".*.order.[a-z]*\\|");
    Matcher matcher = pattern.matcher(sb);

    // Attempt to find all matching keys
    List<String> matchingLabelKeys = new ArrayList<String>();
    while (matcher.find()) {
      String key=matcher.group();
      matchingLabelKeys.add(key.substring(0,key.length()-1));
    }

    // Show results
    for (String value: matchingLabelKeys) {
      System.out.format("Key=%s Resource=%s",value,labels.getString(value));
    }

  }

}