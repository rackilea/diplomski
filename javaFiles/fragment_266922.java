@Bean
public com.xyz.profiler.Profiler profiler() {
    com.xyz.profiler.Profiler profiler = Aspects.aspectOf(com.xyz.profiler.Profiler.class);
    profiler.setProfilingStrategy(jamonProfilingStrategy()); // assuming you have a corresponding @Bean method for that bean
    return profiler;
}