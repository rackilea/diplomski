private String resolve(final String artifactName, final IConfiguration configuration) throws CdtVariableException{
        ICdtVariableManager mngr = CCorePlugin.getDefault().getCdtVariableManager();
        return mngr.resolveValue(artifactName, "", File.pathSeparator, ManagedBuildManager.getDescriptionForConfiguration(configuration));
}

private String getResolvedArticatName(final IConfiguration configuration) throws CdtVariableException{
    String artifactName = configuration.getArtifactName();
    return resolve(artifactName);
}