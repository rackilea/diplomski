int index = 0;
while (index < list.size()) {
    if (/*...you want to remove the item...*/) {
        list.removeAt(index);
    } else {
        // Not removing, move to the next
        ++index;
    }
}