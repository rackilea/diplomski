public class MissionPlannerIT extends JUnit4CitrusTest {

  @Autowired
  @Qualifier("routeGeneratorServer")
  private HttpServer rgServer;
  @Autowired
  @Qualifier("routeAssessorServer")
  private HttpServer raServer;