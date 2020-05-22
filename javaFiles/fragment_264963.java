@Entity
@Table(name = "item")
public class Item extends Model
{
    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<ShopSection> sections;
}

@Entity
@Table(name = "shop_section")
public class ShopSection extends Model
{
    public List<Item> findActiveItems(int page, int length)
    {
        return Item.find("select distinct i from Item i join i.sections as s where s.id = ?", id).fetch(page, length);
    }
}