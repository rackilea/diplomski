final static Pattern PATTERN = Pattern.compile( "ScriptExecThread\\(([0-9]+)\\).*.starting.*.on" );

public static String getHungThread(final String str ) {     
    Matcher m = PATTERN.matcher(str);
    boolean hasHung = m.find();
    if ( hasHung ) {
      return m.group(1);
    } else {
      return null;
    }
}