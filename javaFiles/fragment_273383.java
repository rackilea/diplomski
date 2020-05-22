String s =  "Your shipment 6016499344 was delivered at ABC JD014600001678885621 Piece ID";
Matcher m = Pattern.compile("\\bJD\\w{18}\\b").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}