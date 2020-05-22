interface Configurable {
    List<String> getConfigurationList();
}

// class which doesn't have any configuration
class SimpleConfigurable implements Configurable {
    public List<String> getConfigurationList() { return Collections.emptyList(); }
}