public class Item
{
    int id;
    String name;

    public String toString()
    {
        return this.name+"("+id+")";
    }
}
(...)
Item array[]=new  Item[]{ ... };//fill the array with your items
JComboBox c=new  JComboBox(array);
(...)
//use the combo
(...)
Item selected=(Item)c.getSelectedItem();
System.err.println("id is "+selected.id);