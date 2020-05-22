@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class School {

     @JsonSerialize(using = TeachersSerializer .class)
     private Set<Teacher> teachers = new HashSet<>();

}