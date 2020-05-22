if (customMethodSecurityMetadataSource != null) {
  sources.add(customMethodSecurityMetadataSource);
}
if (prePostEnabled()) {
  sources.add(new PrePostAnnotationSecurityMetadataSource(attributeFactory));
}
if (securedEnabled()) {
  sources.add(new SecuredAnnotationSecurityMetadataSource());
}
if (jsr250Enabled()) {
  sources.add(jsr250MethodSecurityMetadataSource);
}