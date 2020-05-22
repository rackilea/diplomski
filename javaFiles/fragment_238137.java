private static DependencyNode generateNode(String groupId, String artifactId, String version) {
    DependencyNode node = Mockito.mock(DependencyNode.class);
    Artifact artifact = Mockito.mock(Artifact.class);
    Mockito.when(node.getArtifact()).thenReturn(artifact);
    // mock artifact
    Mockito.when(artifact.getGroupId()).thenReturn(groupId);
    Mockito.when(artifact.getArtifactId()).thenReturn(artifactId);
    Mockito.when(artifact.getVersion()).thenReturn(version);

    return node;
}