import java.util.Map;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
private Map<String, Object> attributes;

public User(Map<String, Object> attributes) {
    this.attributes = attributes;
}

public Object getAttribute() {
    return this.attributes;
}}