final List<Item> items = new ArrayList<Item>();
items.add(new Item("a", "b"));
items.add(new Item("c", "d"));
items.add(new Item("e", "f"));
items.add(new Item("g", "h"));

final ExampleAdapter adapter = new ExampleAdapter(context, items);
listView.setAdapter(adapter);