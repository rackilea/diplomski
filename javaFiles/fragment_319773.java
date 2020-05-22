try
{

    String purpose = "com.path.to.your.package." + purposeString + "Purpose";
    Context context = (Context) Class.forName(purpose).newInstance();
}
catch(ClassNotFoundException ex)
{
    ex.printStackTrace();
}