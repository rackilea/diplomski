public class HotSwappablePluggableList<T>
        extends PluggableList<T>
{
    private EventList<T>         syncSourceList    = new BasicEventList<>();
    private ListEventListener<T> listEventListener = null;

    public HotSwappablePluggableList()
    {
        super(new BasicEventList<T>());
    }

    @Override
    public void setSource(final EventList<T> sourceList)
    {
        getReadWriteLock().writeLock().lock();
        try
        {
            if (listEventListener != null)
            {
                syncSourceList.removeListEventListener(listEventListener);
            }

            syncSourceList = sourceList;

            final EventList<T> syncTargetList = createSourceList();
            listEventListener = GlazedLists.syncEventListToList(syncSourceList, syncTargetList);

            super.setSource(syncTargetList);
        }
        finally
        {
            getReadWriteLock().writeLock().unlock();
        }
    }
}