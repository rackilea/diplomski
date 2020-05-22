for (int i = 0; i < 5; i++) {
        item.setFirstName("AA::" + i);  <-- error happened here because item is null
        item.setLastName("BB::" + i);
        item.setAddress("New City " + i);
        item.setSex("Male");
        itemList.add(item); 
        item = new PersonalInfo();
    }