static class SomeInterfaceCollection {
    final Set<SomeInterface> implementations;

    SomeInterfaceCollection(Set<SomeInterface> implementations) {
        this.implementations = implementations;
    }
}

@Bean
public SomeInterfaceCollection collect(Collection<SomeInterface> beans,
        Collection<Collection<SomeInterface>> beanCollections) {
    final HashSet<SomeInterface> merged = ...
    return new SomeInterfaceCollection(merged);
}