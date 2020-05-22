@Bean
public VelocityEngineFactoryBean velocityEngine() {
    VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();

    Properties velocityProperties = new Properties();
    velocityProperties.put("resource.loader", "class");
    velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    velocityEngine.setVelocityProperties(velocityProperties);

    return velocityEngine;
}