@Entity
public class Category implements Serializable {

    public MutableInt id = new MutableInt(-1);

    private List<CategorizedItem> categorizedItemList = new ArrayList<CategorizedItem>();

    @Transient
    public MutableInt getIdAsMutableInt() {
        return this.id;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return this.id.intValue();
    }

    public void setId(Integer id) {
        return this.id.setValue(id);
    }

    @OneToMany(mappedBy="category")
    @JoinColumn(name="CATEGORY_ID", insertable=false, updateable=false)
    @Cascade(CascadeType.SAVE_UPDATE)
    public List<CategorizedItem> getCategorizedItemList() {
        return categorizedItemList;
    }

    // setter's

    /**
      * Use this method when you have a saved Item
      */
    public void addCategorizedItem(CategorizedItem categorizedItem) {
        categorizedItem.setCategorizedItemId(new CategorizedItemId(getIdAsMutableInt(), categorizedItem.getItem().getIdAsMutableInt()));
        categorizedItem.setCategory(this);

        getCategorizedItemList().add(categorizedItem);
    }

}