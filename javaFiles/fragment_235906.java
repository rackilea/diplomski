if (urlSet != null && urlSet.size() > 1) {
    sm.add(new WarnStatus("Resource [" + resourceName + "] occurs multiple times on the classpath.", loggerContext));
    for (URL url : urlSet) {
        sm.add(new WarnStatus("Resource [" + resourceName + "] occurs at [" + url.toString() + "]", loggerContext));
    }
}