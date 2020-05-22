Map<Resource, Set<Resource>> map = resourceList.stream()
    .collect(Collectors.groupingBy(Resource::getSubnet, Collectors.toSet()))
    .values().stream()
    .collect(Collectors.toMap(
        set -> set.iterator().next(),
        set -> {
            Set<Resource> other = new HashSet<>(resourceList);
            other.removeAll(set);
            return other;
        }));