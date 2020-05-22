// Assuming this static import
import static org.jooq.impl.DSL.*;

public static Field<Map<String, String>> jsonSet(
    Field<Map<String, String>> field,
    String key,
    String value
) {
    return field("json_set({0}, {1}, {2})", field.getDataType(), field, inline(key), val(value));
}