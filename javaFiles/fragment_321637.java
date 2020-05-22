@Entity
public class Menu
{
    protected class ItemList extends AbstractList<Item>
    {
        protected ArrayList<Item> list;

        public ItemList()
        {
            super();
            list = new ArrayList<>();
        }

        public ItemList(Collection<? extends Item> c)
        {
            super();
            list = new ArrayList<>(c.size());
            addAll(c);
        }

        @Override
        public boolean add(Item item)
        {
            if(!Objects.equals(merchant, item.merchant))
            {
                throw new IllegalArgumentException();
                // or return false;
            }

            return list.add(item);
        }

        @Override
        public Item get(int index)
        {
            return list.get(index);
        }

        @Override
        public int size()
        {
            return list.size();
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    protected Merchant merchant;

    @Column(name = "name", length = 45)
    protected String name;

    @ManyToMany
    @JoinTable(name = "MENU_ITEM",
        joinColumns = @JoinColumn(name = "menu_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    protected List<Item> items = new ItemList();

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = new ItemList(items);
    }
}