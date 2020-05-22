@Configuration
class RetrieverProvider {
    @Bean 
    Retriever<Artifact> getArtifact() {
        return new RetrieverImpl<Artifact>() {};
    }

    @Bean 
    Retriever<Material> getMaterial() {
        return new RetrieverImpl<Material>() {};
    }
}

class InjectedAttempt {
    // at injection time, i.e. runtime, type erasure prevent spring to distinguish
    @Autowired Retriever<Artifact> foo; // this type
    @Autowired Retriever<Material> bar; // from this type
    // so it cannot perform injection by type
}