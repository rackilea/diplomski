@Entity
public class SubCategory implements Serializable {

    private static final long serialVersionUID = 7750738516036520962L;

    @Id
    @GeneratedValue
    @Expose
    private Integer subCategoryId;

    @NotEmpty(message = "The subcategory name must not be empty")
    @Size(min = 3, max = 20, message = "Minimum 3 to 20 characters allowed")
    @Expose
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;