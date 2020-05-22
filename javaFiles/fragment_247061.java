for (int i=0, i<result.size(); i++)
{
    String type =  results.get(i).mText1;
    String sender=  results.get(i).mText2; 

    Toast.makeText(this, "" + type, Toast.LENGTH_LONG).show();
    Toast.makeText(this, "" + sender, Toast.LENGTH_LONG).show();

}