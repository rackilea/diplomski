@Entity
@Table(name="person")
public class Person {
    ...

    @OneToOne(mappedBy="person")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Passport passport;
    ...
}