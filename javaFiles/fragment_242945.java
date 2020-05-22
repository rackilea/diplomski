@Subscribe
public void onDeployEvent(RepositoryItemEventStoreCreate event)
{
  StorageItem item = event.getItem();
  writeOut(item, "+ "); 
}