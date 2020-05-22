public interface ItemFactory<E> {
    E create(int[] values);

    public static class DrawItemFactory implements ItemFactory<DrawItem> {

        @Override
        public DrawItem create(int[] values) {
            return new DrawItem(values);
        }           
    }

    public static class DrawNumberFactory implements ItemFactory<DrawNumber> {

        @Override
        public DrawNumber create(int[] values) {
            return new DrawNumber(values);
        }           
    }
}