@Configuration
public class AppConfig {
    @Bean
    public Map<SomeEnum, EnumMappedBean> getBeansMappedByEnum(@NonNull Collection<EnumMappedBean> enumBeans) {
        return enumBeans.stream()
                .collect(toMap(EnumMappedBean::getSomeEnum, Function.identity()));
    }
}