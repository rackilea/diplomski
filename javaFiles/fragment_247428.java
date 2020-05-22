while (iterator.hasNext()) {
    System.out.println(iterator.next()); // first valie returned by iterator
    if (iterator.next().equals("Nick") { // second value returned by the iterator
        iterator.remove(); // second value returned by the iterator removed 
    }
}