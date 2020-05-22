public class ItemAdapter extends XmlAdapter<ItemProxy, Item>
{
    @Override
    public ItemProxy marshal( Item v ) throws Exception
    {
        ItemProxy proxy = new ItemProxy();

        proxy.setCategory( v.getCategory().getCode() );
        proxy.setSubcategory( v.getSubCategory().getCode() );
        proxy.setName( v.getName() );

        return proxy;
    }

    @Override
    public Item unmarshal( ItemProxy v ) throws Exception
    {
        Item item = new Item();

        Category category = new Category( v.getCategory() );
        SubCategory subCategory = new SubCategory( v.getSubcategory(), category );

        item.setName( v.getName() );
        item.setCategory( category );
        item.setSubCategory( subCategory );

        return item;
    }
}