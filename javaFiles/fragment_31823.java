@Execute
public void execute(@Named(IServiceConstants.ACTIVE_PART) final MPart part)
{
  Object client = part.getObject();
  ContextInjectionFactory.invoke(client, PersistAs.class, part.getContext());
}