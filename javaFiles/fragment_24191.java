if (thing.size() < 2)  // special case
    return;

int min = thing.get(0), minLoc = 0;

for (int i = 1; i < thing.size(); i++) {
    int next = thing.get(i);

    if (next < min) {
        min = next;
        minLoc = i;
    }
}

thing.add(0, thing.remove(minLoc));