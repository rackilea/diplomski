@Override
public void dispose()
{
  ISelectionService service = (ISelectionService)getSite().getService(ISelectionService.class);

  service.removeSelectionListener(myListener);

  super.dispose();
}