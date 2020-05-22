@Slf4j
@Component
public class ActuatorLogger {

  public ActuatorLogger(@Autowired PathMappedEndpoints pme) {
    log.info("Actuator base path: {}", pme.getBasePath());
    pme.getAllPaths().forEach(p -> log.info("Path: {}", p));
  }
}