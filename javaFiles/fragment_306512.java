@Entity
    public class Department {
        @Id
        private int id;

        @ManyToOne(mappedBy = "department")
        private Manager manager;
        ...
    }