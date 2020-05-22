try
{
    String string = "swimming";
    MyActivity.class.getMethod(string, null).invoke(this, null);
}
catch(Throwable t)
{
    t.printStackTrace(); // might want to do something else here
}