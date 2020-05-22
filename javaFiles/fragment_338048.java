class ConversionServiceFactoryWithoutStringToBooleanConverter : ConversionServiceFactoryBean() {

    override fun createConversionService(): GenericConversionService {
        val conversionService = super.createConversionService()
        conversionService.removeConvertible(String::class.java, java.lang.Boolean::class.java)
        return conversionService
    }
}