Iterator<String> it = list.iterator();
while (it.hasNext()) {
    if (/*...you want to remove `it.next()`...*/) {
        it.remove();
    }
}