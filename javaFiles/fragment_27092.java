List<EmployeeXML> empListXML = service
    .path("rest")
    .path("GetService")
    .path("getEmployeeListXML")
    .accept(MediaType.APPLICATION_XML)
    .get(new GenericType<List<EmployeeXML>>() {});