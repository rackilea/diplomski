public static void main(String[] args)
{
    JButton first = new JButton("button");
    System.out.println(first.getInputMap().getParent());

    InputMap im = (InputMap) UIManager.get("Button.focusInputMap");
    System.out.println(im);
}