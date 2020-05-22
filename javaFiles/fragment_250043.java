@Entity  @IdClass(PersonId.class)
public class MyPerson {
    @Id private String firstname;
    @Id private String lastname;
    @Id private LocalDate dob;

    // Getters and setters here    
}