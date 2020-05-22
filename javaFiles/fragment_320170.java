public class Employee {

    // ...

    // Do not serialize this field
    @JsonIgnore

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewee")
    private Review review;

    // Read-only access to the foreign key
    @Column(name = "Review_id", insertable = false, updatable = false)
    private Integer reviewId;

    // ...
}