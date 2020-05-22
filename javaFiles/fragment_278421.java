static abstract class Item<I extends Item<I, T>, T extends ItemTemplate<I, T>> {
    T template;
}
static abstract class ItemTemplate<I extends Item<I, T>, T extends ItemTemplate<I, T>> {
    abstract I createItem();
}

// JPA Domain Objects:
static class Armor extends Item<Armor, ArmorTemplate> {}
static class ArmorTemplate extends ItemTemplate<Armor, ArmorTemplate> {
    public final int hitpoints;

    public ArmorTemplate(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    @Override
    Armor createItem() {
        return new Armor();
    }
}

// This POJO can be CDI managed
static class ItemDao {
    // @Inject public EntityManager em;

    public <I extends Item<I, T>, T extends ItemTemplate<I, T>> 
    List<I> createItemsFromTemplates(List<T> templates) {
        List<I> result = new ArrayList<I>();
        for (T template : templates) {
            I item = template.createItem();
            item.template = template;
            // em.persist(item);
            result.add(item);
        }
        return result;
    }
}

public static void main(String[] args) {
    List<ArmorTemplate> armorTemplates = Arrays.asList(
            new ArmorTemplate(100), new ArmorTemplate(80));

    List<Armor> armorItems = new ItemDao().createItemsFromTemplates(armorTemplates);

    for (Armor armor : armorItems) {
        System.out.println(armor.template.hitpoints);
    }
}