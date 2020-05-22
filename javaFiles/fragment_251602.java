@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyClass {

     @JsonIgnore // only admins
     private Set<Teacher> teachers = new HashSet<>();

}