// from bundle org.eclipse.equinox.p2.console
    import org.eclipse.equinox.internal.p2.console.ProvisioningHelper;

    URI repoUri = new URI(UPDATE_SITE_URL);
    try {
        ProvisioningHelper.addMetadataRepository(repoUri);         
    } catch( Exception e ) {
        LOG.warn("Can not add update repository: " + repoUri);           
    }
    try {
        ProvisioningHelper.addArtifactRepository(repoUri);          
    } catch( Exception e ) {
        LOG.warn("Can not add update repository: " + repoUri);
    }