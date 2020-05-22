// List of animals...
final private String[] animals = { "dog", "cat", "mouse" };

/*...*/

// Map of animal icons...
Map<String, Icon> mapImages = new HashMap<>();
// Build the icon image mapping
for (String animal : animals) {
    mapImages.put(animal, new ImageIcon(ImageIO.read(getClass().getResource("/" + animal + ".jpg))))
}

// Create a new cell renderer, passing the mappings
ImageCellRenderer renderer = new ImageCellRenderer(mapImages);

// Create a new combo box
JComboBox<String> comboBox = new JComboBox<String>(animals);
// Apply the renderer
comboBox.setRenderer(renderer);

/*...*/

public class ImageCellRenderer extends DefaultListCellRenderer {

    // Icon mappings
    private Map<String, Icon> mapImages

    public ImageCellRenderer(Map<String, Icon> mapImages) {
        // Make a new reference to the icon mappings
        this.mapImages = new HashMap<>(mapImages);
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof String) {
            // Look up the icon associated with the animal...
            Icon icon = mapImages.get(value.toString());
            setIcon(icon);
        }
        return this;
    }

}