class YourModel implements ComboBoxModel{

//implements all interface methods required...
@override
public YourModel(String filename)
{
    comboBoxItemList = new ArrayList<String>();
    // open your file
    // add every entry to the the list
}
@override
public Object getElementAt(int index)
{
    return comboBoxItemList.get(index);
}
List<String> comboBoxItemList;
}