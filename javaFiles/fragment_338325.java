Partition testPartition = addPartition("test", "ou=test,dc=apache,dc=org");
    Partition servicePartition = addPartition("service", "ou=service,ou=test,dc=apache,dc=org");


    addIndex(infopulsePartition, "objectClass", "ou", "uid");
    addIndex(servicePartition, "objectClass", "ou", "uid");

    service.startup();

    if (!service.getAdminSession().exists(infopulsePartition.getSuffixDn())) {
        Dn dnApache = new Dn("ou=test,dc=apache,dc=org");
        Entry entryApache = service.newEntry(dnApache);
        entryApache.add("objectClass", "top", "domain", "extensibleObject");
        entryApache.add("dc", "Apache");
        service.getAdminSession().add(entryApache);
    }

    if (!service.getAdminSession().exists(servicePartition.getSuffixDn())) {
        Dn dnApache = new Dn("ou=service,ou=test,dc=apache,dc=org");
        Entry entryApache = service.newEntry(dnApache);
        entryApache.add("objectClass", "top", "domain", "extensibleObject");
        entryApache.add("dc", "Apache");
        service.getAdminSession().add(entryApache);
    }