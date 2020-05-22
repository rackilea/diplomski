/*
 * Helper class to generate formatted toString() methods for pojos
 */
public class CustomToStringBuilder {
    private StringBuilder builder;
    private Object o;

    public CustomToStringBuilder(Object o) {
         builder = new StringBuilder();
         this.o = o;
    }

    public CustomToStringBuilder appendItem(String s, Object o) {
        builder.append("    ").append(s).append(": ").append(toIndentedString(o)).append("\n");
        return this;
    }

    public String getString() {
        return "class " + o.getClass().getSimpleName() + "{ \n" + builder.toString() + "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}