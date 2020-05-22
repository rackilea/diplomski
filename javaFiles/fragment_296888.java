@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface GuiceManaged {
    public Class<? extends Module>[] module();
    public String address();
}