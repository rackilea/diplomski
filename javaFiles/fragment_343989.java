@Autowired
ServletContext context; 

public Collection<String> getFileList(String path) {
    Collection<String> result = new ArrayList<String>();

    Set<String> paths = context.getResourcePaths(path);
    for (String p : paths) {
        String[] parts = p.split("/");
        result.add(parts[parts.length-1]);
    }
    return result;
}