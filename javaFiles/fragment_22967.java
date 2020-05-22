class MenuItem
{
    //your class implementation
}

class SubMenuItem extends MenuItem
{
    //your class implementation    
}

ArrayList<MenuItem> list = new ArrayList<MenuItem>();
list.add(new MenuItem(foodName, foodType, price, calories));
list.add(new SubMenuItem( /*your arguments*/ ));