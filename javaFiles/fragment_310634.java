public MainClass {
  public void main(String[] args) {
    ...
    // Some custom way of loading the csv data into a Map<POJO> format
    MetadataLoader loader = new MetadataLoader("pathToData.csv");
    Map<Employee> metadataHashMap = loader.getMetadataMap(employeeEnrichmentData);
    ...

    // Enrichment
    SingleOutputStreamOperator<Employee>> enrichedStream = rawStream
            .map(new MapMetadataToEmployees(metadataHashMap))
            .name("Enrich: with Employee Metadata");

    // Some sink opeartion
    ...

  }
}  

final class MapMetadataToEmployees implements MapFunction<Employee, Employee>, Serializable {

  private Map<Employee> metaDataMap;

  public MapMetadataToEmployees(Map<String, Employee> metaDataMap) {
      this.metaDataMap = metaDataMap;
  }

  @Override
  public Employee map(Employee employee) {

      if (metaDataMap.containsKey(employee.getId())) {

          Employee employeeWithMetaData = metaDataMap.get(employee.getId());

          employee.setSalary(employeeWithMetaData.getSalary);
          employee.setRank(employeeWithMetaData.getRank());
          employee.setBusinessTitle(employeeWithMetaData.getBusinessTitle());
      }

      return employee;
  }
}