class DataService {
  public <T> void save(T data, SaveStrategy<? super T> strategy ){
    if(strategy.beforeSave(data)){
        // persist the data
        strategy.afterSave(data);
    }
  }
}