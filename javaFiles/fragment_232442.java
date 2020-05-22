-keep public class fully_qualified_classname
-keepclassmembers public class fully_qualified_classname  {
    # will ignore all methods
    public <methods>;
    public static final String static_instance_variable_if_any;
}