List<Item> items= new ArrayList<Item>();
List<String> ids = new ArrayList<String>();

    for (Record record: records) { // Loop the rows show above
        if(!ids .contains(record.getId())) { //prevent duplicate Item
          Item item = new Item();
          item.setName(record.getSurname());
          Address address = new Address();
          address.setAddress1 = record.getAddress1();
          address.setAddress2 = record.getAddress2();
          List<Address> addrList = new ArrayList<Address>();
          addrList.add(address);
          item.setAddreses(addrList);
          items.add(item); // add the item into items
       } else {
         for (Item it: items) {
            if(it.getName().equals(record.getSurname()) {
                 Address addr = new Address();
                 addr.setAddress1 = record.getAddress1();
                 addr.setAddress2 = record.getAddress2();
                 it.getAddresses().add(addr);
            }
         }
       }
       Ids.add(record.getId());
    }