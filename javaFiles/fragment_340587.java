HashMap<Integer, Customer> stuff = new HashMap<Integer, Customer>();
stuff.put(0, new Customer());
stuff.put(2, new Customer());
Iterator it = stuff.keySet().iterator();
while(it.hasNext())
{
    ComboBox.addItem(stuff.get(it.next()));
}