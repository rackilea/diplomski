@RequestMapping(method = RequestMethod.POST, path = "newItem")
public ResponseEntity<Item> createItem(@RequestBody Item item) {

    Item item = new Item(name, date, location);
        //save into database
    }