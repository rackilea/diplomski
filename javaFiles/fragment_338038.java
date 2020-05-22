@Autowired
public EmpikSource(EmpikUrlProperties empikUrlProperties, JSoupConnector jSoupConnector, Map<CategoryType, String> categoryToEmpikURL ) {
    this.empikUrlProperties = empikUrlProperties;
    this.jSoupConnector = jSoupConnector;
    categoryToEmpikURL = categoryToEmpikURL;
}