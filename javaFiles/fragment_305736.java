public Object[] getAllDChannelId()
{
  Object[] items = getAllItems();
  Object[] ids = new Object[items.length];
  for (int i = 0; i < items.length; i++)
    ids[i] = items[i].getId();
  return ids;
}