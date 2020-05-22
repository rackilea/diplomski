List<Foo> list = new ArrayList<Foo>();
list.add(new Foo("aa"));
list.add(new Foo("bb"));
list.add(new Foo("cc"));
list.add(new Foo("dd"));

list.get(0).addItem(1, 4);
list.get(0).addItem(2, 2);
list.get(0).addItem(3, 3);
list.get(1).addItem(3, 1);
list.get(1).addItem(1, 1);
list.get(1).addItem(2, 8);
list.get(2).addItem(3, 3);
list.get(3).addItem(2, 10);
list.get(0).addItem(5, 10);

for (Foo foo : list) {
 System.out.print(foo.getName());
 Foo.Item[] ar = foo.getItems().toArray(new Foo.Item[0]);
 for (int i = 1, j = 0; i <= 8; i++) {
   if (j >= ar.length)
    System.out.print(" - ");
   else if (ar[j].getId() == i) {
    System.out.print(" " + ar[j].getValue());
    j++;
   } else
        System.out.print(" - ");
  }
  System.out.println();
}