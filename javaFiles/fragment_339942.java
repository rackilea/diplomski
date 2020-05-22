String pattern = template;
// escape regex special characters
pattern = pattern.replaceAll("([?.])", "\\\\$1");
for (String var : vars.keySet()) {
    // replace placeholders with capture groups
    pattern = pattern.replaceAll("\\$"+var+"\\$", "([\\\\w\\\\s]+?)");
}