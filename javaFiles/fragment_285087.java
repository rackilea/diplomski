@Test
public void testK8sDeployment() {

  new TestKit(system) {
    {
      final KubeFactory mockFactory = mock(KubeFactory.class);
      when(mockFactory.makeNamespace()).thenReturn(mockKubeNamespace);
      when(mockFactory.makeDeployment()).thenReturn(mockKubeDeployment);
      final Props props = Props.create(K8sDeploymentCreator.class, mockFactory);
      final ActorRef underTest = system.actorOf(props);
      // and so on...
    }
  }
}