for (int i = 0; i < 5; i++) {
            item = new PersonalInfo();  <-- I've moved this line
            item.setFirstName("AA::" + i);
            item.setLastName("BB::" + i);
            item.setAddress("New City " + i);
            item.setSex("Male");
            itemList.add(item);

        }