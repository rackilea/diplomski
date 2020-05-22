Foo previousItem = null;
List<Foo> filteredList = new ArrayList<>();

for (Iterator<Foo> iterator = list.iterator(); iterator.hasNext();) {

    Foo item = iterator.next();

    if (previousItem != null && !item.getValue().equals(previousItem.getValue())) {
        filteredList.add(previousItem);
    }

    if (!iterator.hasNext() && !item.getValue().equals(previousItem.getValue())) {
        filteredList.add(item);
    }

    previousItem = item;            
}