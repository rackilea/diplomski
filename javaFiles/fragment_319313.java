String listString = "";

for (String s : row)
{
    listString += s + "\t";
}   

  new KundeTab().kundeAuswahl.setText(listString);