Integer fromValue = list.get(fromPos);
int delta = fromPos < toPos ? 1 : -1;
for (int i = fromPos; i != toPos; i += delta) {
  list.set(i, list.get(i + delta));
}
list.set(toPos, fromValue);