public List<String> findPackageNamesStartingWith(String prefix) {
    return Package.getPackages().stream()
        .map(Package::getName)
        .filter(n -> n.startsWith(prefix))
        .collect(toList());
}