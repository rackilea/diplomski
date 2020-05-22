@Entity
@Table(name = "TB_PRODUCT_CATEGORY_ROLLUP")
public class ProductCategoryRollup  {

    private ProductCategory parent;
    private ProductCategory child;

    @Id    
    @GeneratedValue
    public Integer getId() {
        return super.getId();
    }
    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PRODUCT_CATEGORY_PARENT", nullable=false)  
    public ProductCategory getParent() {
        return parent;
    }
    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PRODUCT_CATEGORY_CHILD", nullable=false)   
    public ProductCategory getChild() {
        return child;
    }
    public void setChild(ProductCategory child) {
        this.child = child;
    }   

}