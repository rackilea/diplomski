final ProvisioningUI ui = ProvUIActivator.getDefault().getProvisioningUI();
IArtifactRepositoryManager artifactManager = ProvUI.getArtifactRepositoryManager(ui.getSession());
artifactManager.addRepository(new URI(UPDATE_SITE_URL);

IMetadataRepositoryManager metadataManager = ProvUI.getMetadataRepositoryManager(ui.getSession());
metadataManager.addRepository(new URI(UPDATE_SITE_URL);