public static ImageIcon checkboxIcon;
public static ImageIcon binIcon;

private static ImageIcon getCheckboxIcon(ImageIcon icon, String fileName) {
    return icon == null ? FileManipulation.getImage(fileName) : icon;
}