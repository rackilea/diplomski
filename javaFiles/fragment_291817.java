public  class Queen<E extends ISuit> implements Icard<E> {
    private Class<E> clazz;

    public Queen(Class<E> clazz) {
        this.clazz = clazz;
    }

    public String getNumber() {
        return "12";
    }

    public E getSuit() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}