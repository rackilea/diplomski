@Entity
public class CategorizedItem implements Serializable {

    private CategorizedItemId categorizedItemId;

    private String userName;

    private Category category;
    private Item item;

    /**
      * required no-arg constructor
      */
    public CategorizedItem() {}
    public CategorizedItem(CategorizedItemId categorizedItemId) {
        this.categorizedItemId = categorizedItemId;
    }
    public CategorizedItem(String userName, Category category, Item item) {
        this.userName = userName;

        this.categorizedItemId = new CategorizedItemId(category.getIdAsMutableInt(), item.getIdAsMutableInt());
    }

    @EmbeddedId
    public CategorizedItemId getCategorizedItemId() {
        return this.categorizedItemId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CATEGORY_ID", insertable=false, updateable=false)
    public Category getCategory() {
        return this.category;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_ID", insertable=false, updateable=false)
    public Item getItem() {
        return this.item;
    }

    // setter's goes here

    /**
      * It MUST implements Serializable
      * It MUST overrides equals and hashCode method
      * It MUST has a no-arg constructor
      *
      * Hibernate/JPA 1.0 does not support automatic generation of compound primary key
      * You SHOULD set up manually
      */
    @Embeddable
    public static class CategorizedItemId implements Serializable {

        private MutableInt categoryId = new MutableInt(-1);
        private MutableInt itemId = new MutableInt(-1);

        /**
          * required no-arg constructor
          */
        public CategorizedItemId() {}
        public CategorizedItemId(MutableInt categoryId, MutableInt itemId) {
            this.categoryId = categoryId;
            this.itemId = itemId;
        }

        @Column(name="CATEGORY_ID", updateable=false, nullable=false)
        public Integer getCategoryId() {
            return this.categoryId.intValue();
        }

        public void setCategoryId(Integer categoryId) {
            return this.categoryId.setValue(categoryId);
        }

        @Column(name="ITEM_ID", updateable=false, nullable=false)
        public Integer getItemId() {
            return this.itemId.intValue();
        }

        public void setItemId(Integer itemId) {
            return this.itemId.setValue(itemId);
        }

        // getter's and setter's

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof CategorizedItemId))
                return null;

            finalCategorizedItemId other = (CategorizedItemId) o;
            return new EqualsBuilder().append(getCategoryId(), other.getCategoryId())
                                      .append(getItemId(), other.getItemId())
                                      .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getCategoryId())
                                        .append(getItemId())
                                        .toHashCode();  
        }

    }

}