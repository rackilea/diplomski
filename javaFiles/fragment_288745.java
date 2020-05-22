for (MethodSecurityMetadataSource s : methodSecurityMetadataSources) {
    attributes = s.getAttributes(method, targetClass);
    if (attributes != null && !attributes.isEmpty()) {
        break;
    }
}