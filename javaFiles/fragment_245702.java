Vector res = new Vector();
Item item = new Item();
item.Name = "maclean";
item.Des = "abcd";
item.Price = "RS 350";
item.image = "c.gif";
res.add(item);
Item item2 = new Item();
item2.Name = "pinto";
item2.Des = "gief";
item2.Price = "RS 450";
item2.image = "d.gif";
res.add(item2);
for (int i = 0; i < res.size(); i++) {
    item = (Item) res.get(i);
    System.out.println(item.Name);
}