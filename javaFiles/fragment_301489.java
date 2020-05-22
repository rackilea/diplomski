public class AggregatingDataLoader implements DataLoader
{
  private Collection<DataLoader> dataLoaders;
  private ExecutorService executorService;

  public AggregatingDataLoader(ExecutorService executorService, Collection<DataLoader> dataLoaders)
  {
    this.executorService = executorService;
    this.dataLoaders = dataLoaders;
  }

  public Collection<Data> loadData() throws DataLoaderException
  {
    Collection<DataLoaderCallable>> dataLoaderCallables = new ArrayList<DataLoaderCallable>>();

    for (DataLoader dataLoader : dataLoaders)
    {
      dataLoaderCallables.add(new DataLoaderCallable(dataLoader));  
    } 

    List<Future<Collection<Data>>> futures = executorService.invokeAll(dataLoaderCallables);

    Collection<Data> data = new ArrayList<Data>(); 
    for (Future<Collection<Data>> future : futures)
    {
       add.addAll(future.get());
    }      

    return data;
  }

  private class DataLoaderCallable implements Callable<Collection<Data>>
  {
    private DataLoader dataLoader;

    public DataLoaderCallable(DataLoader dataLoader)
    {
      this.dataLoader = dataLoader;  
    }

    public Collection<Data> call()
    {
      return dataLoader.load(); 
    }
  }
}