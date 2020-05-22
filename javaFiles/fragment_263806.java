public class ProxyAutowiredCandidateResolver extends SimpleAutowireCandidateResolver {

    @Override
    public Object getSuggestedValue(DependencyDescriptor descriptor) {
        String dependencyClassName = descriptor.getDependencyType().getSimpleName();
        if (dependencyClassName.endsWith("Interface")) {
            return MyProxyUtil.getInstance(descriptor.getDependencyType());
        }

        return super.getSuggestedValue(descriptor);
    }

}