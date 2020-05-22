public void addItem(Item item) {
    items.add(0, item);
    this.databaseHelper.writeOneItem(item);
}

@Test
public void my_test() {
    // GIVEN
    DatabaseHelper databaseHelper = mock(DatbaseHelper.class);
    ItemManager manager = new ItemManager(databaseHelper);
    Item item = new Item()

    // WHEN
    manager.addItem(item);

    // THEN
    verify(databaseHelper).writeOneItem(item); // This verifies that the method writeOneItem of the "mock" is called with the "item" parameter
}

// Another test would check that the item is added to the "items" collection