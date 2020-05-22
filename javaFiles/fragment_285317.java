public <T> Set<T> getSameTypeEntity(Class<T> cls) {
    Set<T> sameTypeEntities = new HashSet<>();
    if (cls == Project.class) {
        sameTypeEntities.addAll((Collection<? extends T>) projects);
    } else {
        projects.stream()
                .flatMap(p -> p.getWorkersOnProject().stream())
                .filter(cls::isInstance)
                .map(cls::cast)
                .forEach(sameTypeEntities::add);
    }
    return sameTypeEntities;
}