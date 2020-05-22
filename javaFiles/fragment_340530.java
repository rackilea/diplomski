public static String escapeForLogs(String input) {
  return org.apache.commons.lang3.StringUtils.replaceEach(
    input,
    new String[] { "\r\n", "\r", "\n", "\t" },
    new String[] { "\\\\n", "\\\\n", "\\\\n", "\\\\t" }
  );
}