public static void main(String[] args) {
    CopyCollection res = new CopyCollection();
    Item item = new Item();
    item.Name = "maclean";
    item.Des = "abcd";
    item.Price = "RS 350";
    item.image = "c.gif";
    res.add(item);
    item.Name = "pinto";
    item.Des = "gief";
    item.Price = "RS 450";
    item.image = "d.gif";
    res.add(item);
    for (int i = 0; i < res.size(); i++) {
        item = res.get(i);
        System.out.println(item.Name);
    }
}