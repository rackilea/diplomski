import com.arangodb.entity.DocumentField;
import com.arangodb.entity.DocumentField.Type;

public class MyObject {
    @DocumentField(Type.KEY)
    private String key;
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;

    public MyObject(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public MyObject() {
        super();
    }
}