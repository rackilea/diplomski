public class IngredientListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Ingredient) {
            Ingredient ingredient = (Ingredient)value;
            setText(ingredient.getName());
            setToolTipText(ingredient.getDescription());
            // setIcon(ingredient.getIcon());
        }
        return this;
    }
}