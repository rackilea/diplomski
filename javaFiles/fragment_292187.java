@Component
public class ArtifactImpl extends AbstractGenericImpl<Artifact> {
}

@Component
public class MaterialImpl extends AbstractGenericImpl<Material> {
}

@Component
class Usage {
  @Autowired ArtifactImpl foo;
  @Autowired MaterialImpl bar;
}