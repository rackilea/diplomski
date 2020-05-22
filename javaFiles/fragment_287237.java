@Entity
@Table(name = "Category")
public class Category{

        @Id
        @Column(name = "cat_id")
        private Long id;

        @Column(name = "title")
        private String title;

        @OneToMany(mappedBy = "category")
        private List<ACategory> aList;

        // no-arg constructor
        public Category(){
            this.aList = new ArrayList<>();
        }

        // getters & setters
}