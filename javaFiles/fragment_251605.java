@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Teachers implements Serializable {
     @JsonSerialize(using = TeachersSerializer.class)
     private Set<Teacher> teachers = new HashSet<>();

     public Teachers(Set<Teacher> teachers){
         this.teachers = teachers;
     }
}