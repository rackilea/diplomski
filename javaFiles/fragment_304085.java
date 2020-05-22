Intent intent = getIntent();
Bundle data = intent.getExtras();
if(data != null)
{
    String one = intent.getString("data_one", null); // use your data type
}
else
{
    // No extra received
}