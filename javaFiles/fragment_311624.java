int size = 1;

List<T> temp = this;

while (temp.getTail() != null) {
    temp = temp.getTail();
    size++;
}