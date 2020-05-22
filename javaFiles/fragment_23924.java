@Retention(RUNTIME)
@Target(FIELD)
@interface DynamicSerializedName {

    String value();

}