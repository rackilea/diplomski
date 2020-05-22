int offset = 0;
int pageSize = 100;
ItemView view = new ItemView(pageSize, offset, OffsetBasepoint.Beginning);
FindItemsResults<Item> find;
boolean more = true;
List<Item> contacts = new ArrayList<Item>();
while (more) {
    find = service.findItems(...);
    contacts.addAll(find.getItems());
    if (find.isMoreAvailable()){
        offset += pageSize;
        view.setOffset(offset);
    } else {
        more = false;
    }
 }