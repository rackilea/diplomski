static final Pattern IS_CONNECTED = Pattern.compile("\\bCONNECTED\\b|\\bEnter command: $|:$");
static final Pattern RESPONSE = Pattern.compile("\\bRESP:(?<code>\\d+);")

if (IS_CONNECTED.matcher(s).matches()) {
    // ...
    Matcher matching_response = RESPONSE.matcher(s);
    if (matching_response.matches()) {
       String code_str = matching_response.group("code");
       result = Integer.parseInt(code_str); // Poor check, can still fail
    }
}