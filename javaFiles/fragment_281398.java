Bundle b = getIntent().getExtras();
if (b != null) 
{
    String wardNumber = b.getString("ward");
    String dateTime = b.getString("dateTime");
}