String s = "5-6 minutes";
Pattern pattern = Pattern.compile("(?<amount>\\d*\\.?\\d+)\\s*(?<unit>[a-zA-Z]+)$");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(0)); 
}