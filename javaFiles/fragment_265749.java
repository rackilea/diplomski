Item item1 = new Item("a");
Item item2 = new Item("b");
Item item3 = new Item("c");

item1.event()
        .concatWith(item2.event())
        .concatWith(item3.event())
        .subscribe();