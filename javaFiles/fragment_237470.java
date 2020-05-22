public static void main(String[] args) {
        Map<Artifact, Set<Artifact>>  map = new HashMap<>();


        Set<Artifact> dependencies = new HashSet<>();
        dependencies.add(new Artifact("org.do.resource ", "1.2.1"));
        dependencies.add(new Artifact("org.test.summer ", "1.5.2"));

        map.put(new Artifact("org.orchestr.something", "5.1.3"), dependencies);
    }