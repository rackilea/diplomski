public interface AnalysisDataStorageService {

      public void save(AnalysisDataObject o); 

      public List<String> getPackageNames(String match);

      public List<String> getClassNames(String match);

      public List<AnalysisDataObject> get(
           String packageNameFilter,
           String classNameFilter,
           int paramterCountFilter,
           Clazz parameterTypeFilter,
           Integer executionTimeOverFilter,
           Integer executionTimeUnderFilter);
 }