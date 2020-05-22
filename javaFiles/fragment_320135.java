public static void addButton(String name)
{
    System.out.println("addButton " + name);

    JButton button = new JButton(name);

    panel.add(button);
    panel.revalidate();
}