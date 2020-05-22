public final String toResourceName(String bundleName, String suffix) {
    StringBuilder sb = new StringBuilder(bundleName.length() + 1 + suffix.length());
    sb.append(bundleName.replace('.', '/')).append('.').append(suffix);
    return sb.toString();
}

....

URL url = classLoader.getResource(resourceName);
...
bundle = new PropertyResourceBundle(stream); // stream comes from url