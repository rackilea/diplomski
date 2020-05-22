interface SaveStrategy<T> {
  boolean beforeSave(T data);
  void afterSave(T data);
}

class SomeFancyProjectSaveStrategy implements SaveStrategy<Project> {

  public SomeFancyProjectSaveStrategy( /*parameters*/) {
  } 

  public boolean beforeSave(Project data) {
     //whatever you like
  }

  public void afterSave(Project data) {
     //whatever you like
  }
}