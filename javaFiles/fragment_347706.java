Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnProperty(name="enable.monitor", havingValue="true")
public @interface Monitoring {
}