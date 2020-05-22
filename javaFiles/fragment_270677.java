int i;
boolean lol = false;
for (i=0; i<arr.size(); i++) {
    Usable usable = arr.get(i);
    if (usable.getId() == ident) {
        arr.remove(i);
        lol = true;
    }
}