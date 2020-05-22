public class CategoryDaoSelectProvider {
public static String findByParentIdAndName(Map<String, Object> params) {
    Long parentId = (Long)params.get("parentId");  // WHY IS THIS HERE???

    StringBuffer buffer = new StringBuffer();
    buffer.append("SELECT COUNT(id) FROM Category ");

    if (parentId == null) {
        buffer.append("WHERE parentId IS NULL ");
    } else {
        buffer.append("WHERE parentId = #{parentId} ");
    }

    buffer.append("AND LOWER(name) = LOWER(#{name}) ");

    return buffer.toString();
}