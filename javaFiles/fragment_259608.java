String s = "Mozilla/5.0 (Linux; U; fr-fr; Desire HD Build/FRG83D) **MyApp/2.2.1** AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533";
Matcher m = Pattern.compile("(?<=MyApp/)\\d+(?:\\.\\d+)+").matcher(s);
if(m.find())
{
    System.out.println(m.group());
}