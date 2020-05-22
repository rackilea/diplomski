file = new File("/home/abhumbe/Sample.drl");
resource = kieServices.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
kfs.write(resource);

file = new File("/home/abhumbe/Sample2.drl");
resource = kieServices.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
kfs.write(resource);


KieBuilder kb = kieServices.newKieBuilder(kfs);
kb.buildAll();