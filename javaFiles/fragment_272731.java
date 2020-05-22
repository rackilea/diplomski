String tmp = "";
for(int i=0; i<homeImprove.length; i++)
{
   if (isWhat[i] != 1)
   {
      msg = homeImprove[i].doTheElectric();
   }
   else
   {
      msg = homeImprove[i].tileIt();
   }

   tmp += "Company: "+homeImprove[i].getCompanyName() + "\t" +
      "Final Price: "+ homeImprove[i].computeBid(price[i]) + "\t" +
      "msg: " + msg + "\n";   

}
textField.setText(tmp);