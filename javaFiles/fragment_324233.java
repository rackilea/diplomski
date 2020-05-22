Map<String, Object> properties = new HashMap<String, Object>(1);
    properties.put(JAXBContextProperties.SESSION_EVENT_LISTENER, new SessionEventAdapter() {

        @Override
        public void postLogin(SessionEvent event) {
            Project project = event.getSession().getProject();
            for(ClassDescriptor descriptor : project.getOrderedDescriptors()) {
                for(DatabaseMapping mapping : descriptor.getMappings()) {
                    mapping.setAttributeAccessor(new MyAttributeAccessor(mapping.getAttributeAccessor()));
                }
            }
            super.preLogin(event);
        }

    });

    JAXBContext jc = JAXBContext.newInstance(new Class[] {Foo.class}, properties);