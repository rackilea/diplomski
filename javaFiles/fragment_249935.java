String url = "http://biz-test.waze.com/providers/224/billing_details";
Pattern p = Pattern.compile("(?<=providers/)(\\d+)");
Matcher m = p.matcher(url);
if(m.find()){
    System.out.println(m.group(1)); // 224
}