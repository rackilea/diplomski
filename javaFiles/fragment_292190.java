@Configuration
class RetrieverProvider {

    @Bean @Qualifier("artifact") Retriever<Artifact> getArtifact() {
        return new RetrieverImpl<Artifact>() {};
    }

    @Bean @Qualifier("material")
    Retriever<Material> getMaterial() {
        return new RetrieverImpl<Material>() {};
    }


}

class Injected {

    @Autowired @Qualifier("artifact") Retriever<Artifact> foo;

    @Autowired @Qualifier("material") Retriever<Material> bar;
}