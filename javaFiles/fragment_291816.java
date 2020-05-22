public E getSuit(Class<E> clazz) {
    try {
        return clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
    // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
}