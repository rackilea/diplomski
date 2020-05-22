@Bean(name = "myBean")
TargetBean targetBean2 () {
    return new TargetBean("bean2");
}

@Bean(name = "myBean")
TargetBean targetBean3 () {
    return new TargetBean("bean3");
}