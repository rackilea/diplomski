private boolean supportsInternal(Class<?> clazz, boolean checkForXmlRootElement) {
        if (checkForXmlRootElement && AnnotationUtils.findAnnotation(clazz, XmlRootElement.class) == null) {
            return false;
        }
        if (StringUtils.hasLength(getContextPath())) {  // << -----
            String packageName = ClassUtils.getPackageName(clazz);
            String[] contextPaths = StringUtils.tokenizeToStringArray(getContextPath(), ":");
            for (String contextPath : contextPaths) {
                if (contextPath.equals(packageName)) {
                    return true;
                }
            }
            return false;
        }
        else if (!ObjectUtils.isEmpty(getClassesToBeBound())) {
            return Arrays.asList(getClassesToBeBound()).contains(clazz);
        }
        return false;
    }