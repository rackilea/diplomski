@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = -5774598582410455895L;

    @Id
    @GeneratedValue
    @Expose
    private int categoryId;

    @NotEmpty(message = "The category name must not be empty")
    @Size(min = 3, max = 20, message = "Minimum 3 to 20 characters allowed")
    @Expose
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Expose
    private List<SubCategory> subCategory;