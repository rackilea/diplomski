@Bean(name = "myBean2")
@Qualifier("myBean")
TargetBean targetBean2() {
    return new TargetBean("bean2");
}

@Bean(name = "myBean3")
@Qualifier("myBean")
TargetBean targetBean3() {
    return new TargetBean("bean3");
}