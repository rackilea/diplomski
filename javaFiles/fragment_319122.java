Class<?>[] classes = {B.class};
AdvisedSupport config = new AdvisedSupport(classes);
try {
    config.setTargetSource(((Advised) b).getTargetSource());
} catch (Exception e) {
    e.printStackTrace();
}
for (Advisor advisor : ((Advised) b).getAdvisors()) {
    Advice advice = advisor.getAdvice();
    if ((advice instanceof AbstractAspectJAdvice) && "advice.A2".equals(
            ((AbstractAspectJAdvice) advice).getAspectName())) {
        // Do not add A2 advisor
    } else {
        config.addAdvisor(advisor);
    }
}
DefaultAopProxyFactory factory = new DefaultAopProxyFactory();
B newB = (B)factory.createAopProxy(config).getProxy();