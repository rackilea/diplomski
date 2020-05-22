public class DTO {
    String key1;
    Object booleanKey;

    public Object getBooleanKey() {
        return booleanKey;
    }

    public void setBooleanKey(Object booleanKey) {
        if (booleanKey instanceof Boolean) {
            this.booleanKey = booleanKey;
        } else {
            // custom code here
        }

    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }
    }