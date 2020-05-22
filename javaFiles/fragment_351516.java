class ClientGroupFilterBuilder {
    private final GroupMapper mapper;
    private List<String> validGroupNames = new ArrayList<>(); 
    public ClientGroupFilter(GroupMapper mapper) {
        this.mapper = mapper;
    }
    public void permit(String name) {
        validGroupNames.add(name);
    }
    public Predicate<Client> build() {
        final Set<Integer> validIds = mapper.getValidIdsForGroupNames(validGroupNames);
        return new Predicate<Client>() {
            @Override
            public boolean test(Client client) {
                return client.getGroupIds().stream().anyMatch(validIds::contains);
            }
        }
    }
}