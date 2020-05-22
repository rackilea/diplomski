final Resource base = Resource.newClassPathResource(".");

if (base != null) {
    context.setBaseResource(base);
} else {    
    // running in a jar
    final URI uri = Service.class.getProtectionDomain().getCodeSource().getLocation().toURI();
    context.setBaseResource(Resource.newResource("jar:" + uri + "!/"));
}