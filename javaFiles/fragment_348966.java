DefaultArtifact artifact = new DefaultArtifact(coordinate);
Artifact pomArtifact = new DefaultArtifact(artifact.getGroupId(), artifact.getArtifactId(), "pom", artifact.getVersion());

ArtifactRequest request = new ArtifactRequest(pomArtifact, Arrays.asList(aetherSession.getRemoteRepository()), null);
pomArtifact = aetherSession.getRepoSystem().resolveArtifact(session, request).getArtifact();

ModelBuilder modelBuilder = new DefaultModelBuilderFactory().newInstance();
ModelBuildingRequest buildingRequest = new DefaultModelBuildingRequest();
buildingRequest.setPomFile(pomArtifact.getFile());
buildingRequest.setProcessPlugins(true);
buildingRequest.setValidationLevel(ModelBuildingRequest.VALIDATION_LEVEL_MINIMAL);

Constructor<?> constr = Class.forName("org.apache.maven.repository.internal.DefaultModelResolver").getConstructors()[0];
constr.setAccessible(true);
ModelResolver modelResolver = (ModelResolver) constr.newInstance(session, null, null,
        serviceLocator.getService(ArtifactResolver.class),
        serviceLocator.getService(VersionRangeResolver.class),
        serviceLocator.getService(RemoteRepositoryManager.class), request.getRepositories());
buildingRequest.setModelResolver(modelResolver);

Model model = modelBuilder.build(buildingRequest).getEffectiveModel();

Xpp3Dom pluginConfiguration = (Xpp3Dom) model.getBuild().getPluginsAsMap().get("com.company.group:my-plugin").getConfiguration();
Xpp3Dom myConfig = pluginConfiguration.getChild("myConfig");
System.out.println(myConfig.getChild("somePropName").getValue()); // prints "someProp"