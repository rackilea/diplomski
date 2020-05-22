class ModifiedBinarySearchTree <N extends Number & Comparable<N>>{
    private BinaryNode<N> root;
    private final Constructor<N> constructor;

    // pass in a Number class, eg new ModifiedBinarySearchTree(Integer.class)
    public ModifiedBinarySearchTree(Class<N> clazz) {
        try {
            constructor = clazz.getConstructor(String.class);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public void treeInput(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            for (String num : line.split("\\s")) {
                insert(constructor.newInstance(num));
        }
    }
}