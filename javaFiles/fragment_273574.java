try
{
    endDialog.button("doX",
            ClassReflection.getDeclaredMethod(this.getClass(), "doX"));
    endDialog.button("doY",
            ClassReflection.getDeclaredMethod(this.getClass(), "doY"));
} catch (ReflectionException e)
{
    // TODO Auto-generated catch block
    e.printStackTrace();
}