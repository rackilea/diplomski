public static <T extends Component> List<T> getAllJTextField(JComponent input, T clazz) {
    List<T> list = new ArrayList<T>();
    for (Component c : input.getComponents()) {
        if (c.getClass().equals(clazz)) {
            list.add((T)c);
        }
    }
    return list;
}