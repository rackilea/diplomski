public MyObj find(long id) {
    return myList.stream()
            .filter(obj -> obj.getId() == id)
            .findFirst()
            .orElse(null);

}