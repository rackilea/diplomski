private int getItemIndex(Item item, Form form) {
    for(int i = 0, size = form.size(); i < size; i++) {
        if(form.get(i).equals(item)) {
            return i;
        }
    }
    return -1;
}