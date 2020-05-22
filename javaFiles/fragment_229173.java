@Entity
    @Table(name = "student")
    public class Student extends BaseEntity {
        private String stuName;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "university_id",updatable = false,insertable = false)
        @JsonIgnoreProperties(value = "students", allowSetters = true)
        private University university;

        //setters and getters
    }