@Bean
@Primary
fun properties(context: AbstractApplicationContext?): PropertySourcesPlaceholderConfigurer {
    val propertySourcesPlaceholderConfigurer = PropertySourcesPlaceholderConfigurer()

    val yaml = YamlPropertiesFactoryBean()
    val os = System.getProperty("os.name").replace(" ", "")

    val resources = context?.environment?.activeProfiles
        ?.map { profile ->
            ClassPathResource("$os-$profile-application.yml")
        }?.plus(ClassPathResource("$os-base-application.yml"))
        ?.toTypedArray()?: emptyArray()

    yaml.setResources(*resources)

    propertySourcesPlaceholderConfigurer.setProperties(yaml.`object`!!)
    return propertySourcesPlaceholderConfigurer
}