private Definition filterDefinition(Definition definition) {
    List<Resource> resourcesToRemove = new ArrayList<>();
    Contract contract = definition.getContract();
    for (Resource resource : contract.getResources()) {
        resourcesToRemove.add(resource);
    }

    for (Resource resource : resourcesToRemove) {
        contract.getResources().remove(resource);
    }

    return definition;
}