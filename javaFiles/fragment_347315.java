// Map simulate your session variables.
Map<String, String> variables = new HashMap<String, String>();
variables.put("POLNO", "V1");
variables.put("POLICYID", "V2");

String input =
/**/"POLICY_NO = %POLNO% and A.POLICY_DETAILS_ID = " +
/**/"b.POLICY_DETAILS_ID and b.ACTION_TIME = " +
/**/"(select max(ACTION_TIME) from POLICY_DETAILS " +
/**/"where POLICY_NO = %POLICYID%)";

StringBuilder output = new StringBuilder(input);

int offset = 0;

Matcher matcher = Pattern.compile("(%)([^%]*)(%)").matcher(input);
while (matcher.find()) {
    // Get only second group (variable name), ignoring % symbols
    String variable = matcher.group(2);
    String value = variables.get(variable);

    // Calculate the offset.
    // The previous replaces can change the string length
    int start = matcher.start() + offset;
    int end = matcher.end() + offset;

    // Replace %XXX% by its value
    output.replace(start, end, value);

    offset -= variable.length() + 2 - value.length();
}