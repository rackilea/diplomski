@Autowired
private ObjectMapper mapper;

@GetMapping(value = "/api/v2/projects")
public String getProjects() {
    List<Project> projects = projectsRepository.findAll();
    String projectsAsJson = mapper.writeValueAsString(projects);
    String processedJson = processProjectsJson(projectsAsJson);
    return processedJson;
}