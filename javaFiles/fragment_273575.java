protected void result(Object object)
{
    try
    {
        ((Method) object).invoke(TestGame.this);
    } catch (ReflectionException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
};