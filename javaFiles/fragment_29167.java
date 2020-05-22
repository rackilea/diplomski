IProjectFacet JAVA_FACET = ProjectFacetsManager.getProjectFacet("jst.java");
IProjectFacet WEB_FACET = ProjectFacetsManager.getProjectFacet("jst.web");

iFacetedProject.installProjectFacet(JAVA_FACET.getVersion("5.0"), null, monitor);

IDataModel aFacetInstallDataModel = DataModelFactory.createDataModel(new WebFacetInstallDataModelProvider());
aFacetInstallDataModel.setBooleanProperty(IJ2EEModuleFacetInstallDataModelProperties.ADD_TO_EAR, false);

iFacetedProject.installProjectFacet(WEB_FACET.getVersion("2.4"), aFacetInstallDataModel, monitor);