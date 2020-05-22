public class BooleanYNMapper {

    public String asString(Boolean bool) {
        return null == bool ?
            null : (bool ? 
                "Y" : "N"
            );
    }

    public Boolean asBoolean(String bool) {
        return null == bool ?
            null : (bool.trim().toLowerCase().startsWith("y") ?
                Boolean.TRUE : Boolean.FALSE
            );
    }
}