StringBuilder string = new StringBuilder();
Iterator<?> it = list.descendingIterator();

while (it.hasNext()) {
    string.append(it.next());
}
System.out.println(string);