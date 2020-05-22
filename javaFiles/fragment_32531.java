private static <T extends Collection<?>> void printCollectionClass(Class<T> c) {
        System.out.println(c.getName());
    }
public static void main(String[] args) {
        printCollectionClass(ArrayList.class);
    }