private static final String IP_PATTERN_STRING = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}:[0-9]{1,6})";
  private static final String NETSTAT_OUTPUT_PATTERN_STRING = "^TCP " + IP_PATTERN_STRING + " " + IP_PATTERN_STRING + " LISTENING\\.\\.\\.$";

  private static final Pattern NETSTAT_OUTPUT_PATTERN = Pattern.compile(NETSTAT_OUTPUT_PATTERN_STRING);

  public String extractIpAddress(String netstatOut) {
       Matcher m = NETSTAT_OUTPUT_PATTERN.matcher(netstatOut);

       if(m.matches()) 
          // depending on if you want the first or the second ip
          // address of the command, use 1 or 2.
          return m.group(1);
       return null;

  }