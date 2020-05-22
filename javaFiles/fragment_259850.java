@Entity
@Table(name = "product")
class Product{   

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int rank;
}