Pattern p = Pattern.compile(
    "(?s)"      + // DOTALL
    ".*"        + // Match anything (to consume everything before 'Name')
    "Name"      + // Match the literal 'Name'
    ".*?"       + // Reluctantly grab everything until...
    "\n"        + // Newline is reached
    "\\s*"      + // Consume leading whitespace
    "(\\S+)"      // Capture at least one non-whitespace character
);
Matcher m = p.matcher(content);

if(m.find()) {
    String name = m.group(1);  // The first capturing group contains "John"
}