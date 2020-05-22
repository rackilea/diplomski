Item item1 = new Item();
item1.id = 1;
item1.name = "somename1"
item1.wood = "somewood1"
item1.prize = 12;

Item item2 = new Item();
item2.id = 1;
item2.name = "somename2"
item2.wood = "somewood2"
item2.prize = 23;


RListMultimap<Long, Item> multimap = redisson.getListMultimap("list"+customer);

// both items uses same id = 1
multimap.add(item1.id, item1);
multimap.add(item2.id, item2);

// returns two items by id = 1
RList<Item> items = multimap.get(1);