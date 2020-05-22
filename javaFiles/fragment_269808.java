@Configuration
class KotlinModuleConfiguration {
    @Bean
    fun kotlinModule(): KotlinModule {
        return KotlinModule()
    }
}