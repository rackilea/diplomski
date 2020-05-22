String value = "internal-pdf://2586543536/Homan-2014-RNA tertiary structure analysis by.pd";
Pattern p = Pattern.compile("internal-pdf://(\\d+)");
Matcher m = p.matcher(value);
if (m.find()){
    System.out.println(m.group(1)); 
}