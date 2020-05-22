@Component
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcludeBeanByQualifierForCollectionAutowired {

    String qualifierToExcludeValue();

    Class<?> aClass();
}