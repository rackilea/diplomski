interface Description {}

interface Item<D extends Description, I extends Item<D, I, C>, C extends Category<D, C, I>>
{
    public C getCategory();   
    public void setCategory(C category);

}

interface Category<D extends Description, C extends Category<D, C, I>, I extends Item<D, I, C>> {    
    public List<I> getItems();   
    public void setItems(List<I> items);
}

class DescriptionImpl implements Description {}

class CustomItem implements Item<DescriptionImpl, CustomItem, CustomCategory> {
    public CustomCategory getCategory() {
        return null;  
    }

    public void setCategory(CustomCategory category) {
    }
}

class CustomCategory implements Category<DescriptionImpl, CustomCategory, CustomItem> {

    public List<CustomItem> getItems() {
        return null;          }

    public void setItems(List<CustomItem> items) {
    }
}