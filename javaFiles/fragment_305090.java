Item item = new Item();
item.setId(collectionSeqRepository.next("item"));
item.setVersion(4);
...

itemRepository.save(item)