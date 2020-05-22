//MyPresenter.java
HasData<MyClass> table = display.addTable();
ListDataProvider<MyClass> dataProvider = new ListDataProvider<MyClass>();
dataProvider.addDataDisplay(table);

//assumes results is a collection of MyClass to display.
//use for loop if you need to do some manipulation to get the objects in
dataProvider.getList().addAll(results);


//MyView.java
@Override // since this implements the definition from the view interface
public HasData<MyClass> addTable()
{
    CellTable<MyClass> table = buildTable(); //boiler-plate table building code in this method
    myPanel.add(table);
    return table;
}