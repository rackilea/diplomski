@Execute
public void execute(@Named(IServiceConstants.ACTIVE_PART) MPart activePart)
{
  Object part = activePart.getObject();

  if (part instanceof MyClass)
   {
     ((MyClass)part).setValue(xxxx);
   }
}