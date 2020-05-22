for (T item: list) {
    if (item.getVolume() < middleItem.getVolume()) {
        leftList.add(item);
    } else {
        rightList.add(item);
    }
}