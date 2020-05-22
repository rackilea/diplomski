String block = "cobble";

if(this.getConfig().contains("pathToValues."+block))
{
   String temp = this.getConfig().getString("pathToValues."+block);//Get the string that we set above

   String[] buyAndSellValues = temp.split(":");

   int Buy = Integer.parseInt(buyAndSellValues[0].replaceAll("[^\\d.]", ""));//replace all non numbers with blanks and turn it into an integer
   int Sell = Integer.parseInt(buyAndSellValues[1].replaceAll("[^\\d.]", ""));

   System.out.println("BUY: "+ Buy);
   System.out.println("SELL: "+Sell);
}