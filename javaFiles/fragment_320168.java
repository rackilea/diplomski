public class Employee {

    // ...

    // Do not serialize this field
    @JsonIgnore

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewee")
    private Review review;

    // ...
}