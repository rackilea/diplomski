String prodUrl = "http://www.ebay.com/itm/Crosman-Pumpmaster-760-Pump-177-Pellet-4-5-mm-BB-Air-Rifle-Black-760B-/251635693266?pt=LH_DefaultDomain_0&hash=item3a96a7f6d2";
String prodPatternString = "(http://www.ebay.com/itm/)(.*?)(hash=)(.*)";
Pattern prodPattern = Pattern.compile(prodPatternString);
Matcher prodMatcher = prodPattern.matcher(prodUrl);
while(prodMatcher.find()){
        String pid = prodMatcher.group(4);
        System.out.println(pid);
}