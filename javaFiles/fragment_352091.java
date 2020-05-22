@Configuration
open class LambdaConfiguration {
    @Bean
    open fun lambdaService(): LambdaServiceHolder {
        val awsLambda = AWSLambdaClientBuilder.defaultClient()
        val service = LambdaInvokerFactory.builder().lambdaClient(awsLambda).build(LambdaService::class.java)
        return LambdaServiceHolder(service);
    }
}