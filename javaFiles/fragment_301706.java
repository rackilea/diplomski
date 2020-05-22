@Entity
public class Item implements Serializable {

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

    @OneToMany(mappedBy="item")
    @JoinColumn(name="ITEM_ID", insertable=false, updateable=false)
    @Cascade(CascadeType.SAVE_UPDATE)
    public List<CategorizedItem> getCategorizedItemList() {
        return this.categorizedItemList;
    }

    // setter's

    /**
      * Use this method when you have a saved Category
      */
    public void addCategorizedItem(CategorizedItem categorizedItem) {
        categorizedItem.setCategorizedItemId(new CategorizedItemId(getIdAsMutableInt(), categorizedItem.getCategory().getIdAsMutableInt()));
        categorizedItem.setItem(this);

        getCategorizedItemList().add(categorizedItem);
    }

}