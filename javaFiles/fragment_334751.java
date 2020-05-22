public class PlayClassPathExtractor {
    public Set<String> getClassPaths(ClassLoader loader) {
        String repr = loader.toString();
        // repr is like "PlayDependencyClassLoader{/class/path.jar, /other/class/path}"
        if (!repr.startsWith("PlayDependencyClassLoader")) {
            return Collections.emptySet();
        }

        String[] nameAndRest = repr.split("\\{"); // ["PlayDependencyClassLoader", ".6..}"]
        repr = nameAndRest[1];
        String[] urls = repr.split("(\\}|,\\s*)");
        Set<String> classPaths = new HashSet<>();
        for (String url : urls) {
            try {
                classPaths.add(new URL(url).getFile());
            } catch (Exception e) {
                // Failed to parse.. just ignore this one
            }
        }

        return classPaths;
    }
}