for (Iterator<Dog> iterator = animals.getDogList().iterator(); iterator.hasNext();) {
    Dog dog= iterator.next();
    if (dog.getDogName().equals(dogName)){
        // Remove the current dog from the iterator and the list.
        iterator.remove();
    }
}