Pattern patt = Pattern.compile("(?i)@#$ThisIsWhatYouWant-(.*?)-End$#@", Pattern.DOTALL);
Matcher match = patt.matcher(reportInString);
if (match.find()) {
  return match.group(1);
}
return null;