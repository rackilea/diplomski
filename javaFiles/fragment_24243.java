class RegexReplacement { 
  final Pattern regex;
  final String replacement;
  RegexReplacement(String regex, String replacement) {
    this.regex = Pattern.compile(regex);
    this.replacement = replacement;
  }
  String replace(String in) { return regex.matcher(in).replaceAll(replacement); }
}