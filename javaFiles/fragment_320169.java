public class Employee {

    // ...

    // Serialize as a single value with the field "id"
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

    // Serialize as told by @JsonIdentityInfo immediately (if false -> on second and further occurrences)
    @JsonIdentityReference(alwaysAsId = true)

    // Rename to "review_id" (would be "review" otherwise)
    @JsonProperty(value = "review_id")

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewee")
    private Review review;

    // ...
}