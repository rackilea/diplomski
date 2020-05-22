@Configuration
class TomcatConfiguration : EmbeddedServletContainerCustomizer {

    override fun customize(container: ConfigurableEmbeddedServletContainer) {
        val factory = container as TomcatEmbeddedServletContainerFactory
        factory.tomcatContextCustomizers = listOf(CustomCustomizer())

    }

    class CustomCustomizer : TomcatContextCustomizer {
        override fun customize(context: Context) {
            context.mapperContextRootRedirectEnabled = false
            context.addServletContainerInitializer(WsSci(), null)
        }
    }

}