/**
 * Returns the search path of URLs for loading classes and resources for the 
 * specified class loader, including those referenced in the 
 * {@code Class-path} header of the manifest of a executable jar, in the 
 * case of class loader being the system class loader. 
 * <p>
 * Note: These last jars are not returned by 
 * {@link java.net.URLClassLoader#getURLs()}.
 * </p>
 * @param cl
 * @return 
 */
public static URL[] getURLs(URLClassLoader cl) {
    if (cl.getParent() == null || !(cl.getParent() 
            instanceof URLClassLoader)) {
        return cl.getURLs();
    }
    Set<URL> urlSet = new LinkedHashSet();
    URL[] urLs = cl.getURLs();
    URL[] urlsFromManifest = getJarUrlsFromManifests(cl);
    URLClassLoader parentCl = (URLClassLoader) cl.getParent();
    URL[] ancestorUrls = getJarUrlsFromManifests(parentCl);

    for (int i = 0; i < urlsFromManifest.length; i++) {
        urlSet.add(urlsFromManifest[i]);
    }
    for (int i = 0; i < ancestorUrls.length; i++) {
        urlSet.remove(ancestorUrls[i]);
    }
    for (int i = 0; i < urLs.length; i++) {
        urlSet.add(urLs[i]);
    }
    return urlSet.toArray(new URL[urlSet.size()]);
}

/**
 * Returns the URLs of those jar managed by this classloader (or its 
 * ascendant classloaders) that have a manifest
 * @param cl
 * @return 
 */
private static URL[] getJarUrlsFromManifests(ClassLoader cl) {
    try {
        Set<URL> urlSet = new LinkedHashSet();
        Enumeration<URL> manifestUrls = 
                cl.getResources("META-INF/MANIFEST.MF");
        while (manifestUrls.hasMoreElements()) {
            try {
                URL manifestUrl = manifestUrls.nextElement();
                if(manifestUrl.getProtocol().equals("jar")) {
                    urlSet.add(new URL(manifestUrl.getFile().substring(0, 
                            manifestUrl.getFile().lastIndexOf("!"))));
                }
            } catch (MalformedURLException ex) {
                throw new AssertionError();
            }
        }
        return urlSet.toArray(new URL[urlSet.size()]);
    } catch (IOException ex) {
        throw new RuntimeException(ex);
    }
}