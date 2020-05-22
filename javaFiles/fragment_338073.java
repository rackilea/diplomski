Iterator<List<String>> itr = addresses.iterator();
while (itr.hasNext()) {
    List<String> element = itr.next();
    ^^^^^^^^^^^^
    System.out.print(element + "\n");
    for (int i = 0; i < element.size(); i++) {
                        ^^^^^^^^
        System.out.println(element.get(i));
    }
    itr.remove();
}