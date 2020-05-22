while(c != null && c.moveToNext())
{
    Log.e("1.6", "2222");

    result = result + c.getString(0) + " " 
                    + c.getString(1) + " " 
                    + c.getString(2) + "\n";
}