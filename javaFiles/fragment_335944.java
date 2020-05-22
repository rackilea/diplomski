@Override
    public Set<Object> getSingletons() {

        Set<Object> singletons = new HashSet<>();

        // All your other Providers, Readers, Writers, e.g:
        singletons.add(new JacksonJaxbJsonProvider());

        // My MessageBodyReader implementation
        singletons.add(new PartialJsonObjectPatchReader());

        return singletons;
    }