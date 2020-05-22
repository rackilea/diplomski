class KubeFactory {
    public KubeNamespace makeNamespace() {
        return new KubeNamespace();
    }
    public KubeDeployment makeDeployment() {
        return new KubeDeployment();
    }
}

public class K8sDeploymentCreator extends AbstractActor {

    private final KubeFactory factory;

    K8sDeploymentCreator() {
        this(new KubeFactory());
    }

    // This constructor allows you to override the factory used for testing
    K8sDeploymentCreator(KubeFactory factory) {
        this.factory = factory;
    }
    @Override
    public Receive createReceive() {
      return receiveBuilder().match(createK8sDeployment.class, msg -> {
          KubeNamespace kubenamespace = factory.makeNamespace();
          KubeDeployment kubeDeployment = factory.makeDeployment();
          // rest is as before...
        });
    }
}