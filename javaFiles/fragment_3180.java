TreeMap<Resource, Set<Resource>> map
                              = new TreeMap<>(Comparator.comparing(Resource::getSubnet));
for(Resource resource: resourceList)
    map.computeIfAbsent(resource, x -> new HashSet<>(resourceList)).remove(resource);

map.forEach((resource,set) -> System.out.println(resource+" -> "
    +set.stream().map(Resource::toString).collect(Collectors.joining(", "))));