public static void main(String[] args){
    ArrayList<JComponent> components = new ArrayList<>();
    components.add(new JPanel());
    components.add(new JPanel());
    components.add(new JPanel());

    System.out.println("Component Visibility Prior to Card Layout:");
    showVisibilityStatus(components);

    JPanel cardPane = new JPanel(new CardLayout());
    for (JComponent component : components){
        cardPane.add(component);
    }

    System.out.println("\nComponent Visibility After Card Layout:");
    showVisibilityStatus(components);
}

public static void showVisibilityStatus(ArrayList<JComponent> components){
    for (JComponent component : components){
        System.out.println(component.isVisible());
    }
}