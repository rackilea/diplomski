@Qualifier
@Retention(RUNTIME)
@Target({ METHOD, FIELD, PARAMETER })
public @interface DataSource {
    @Nonbinding DataSourceName value() default DataSourceName.D1;
}