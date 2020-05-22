/**
 * Regular expression to match file types  - .js/.css/.png/.jpg/.gif
 */
public static final Pattern resources = Pattern.compile("([^\"'\n({}]+\\.(js|css|png|jpg|gif))",
        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

/**
 * Pulls out "resources" from the provided text.
 */
public static Set<String> findResources(URL url, String text) {
    Matcher matcher = resources.matcher(text);
    Set<String> resources = new HashSet<>();
    while (matcher.find()) {
        String resource = matcher.group(1);
        String urlStr = url.toString();
        int endIndex = urlStr.lastIndexOf("/") + 1;
        String parentPath = endIndex > 0 ? urlStr.substring(0, endIndex) : urlStr;
        String fqResource = resource.startsWith("//") ? url.getProtocol() + ":" + resource :
                resource.startsWith("http") ? resource
                        : resource.startsWith("/") ? getBaseUrl(url) + resource : parentPath + resource;
        if (fqResource.contains("?")) {
            fqResource = fqResource.substring(0, fqResource.indexOf("?"));
        }
        resources.add(fqResource);
    }
    return resources;
}