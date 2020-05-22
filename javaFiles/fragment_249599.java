public class MyFrameManager {

    private JFrame     frame;
    private CardLayout frameLayout;

    public MyFrameManager() {
        super();
        frame = new JFrame("My App");
        frame.setLayout(frameLayout = new CardLayout());
        frame.setSize(320, 240);

        // Adding to the layout all possible interfaces, each referenced by its name
        for (PossibleInterfacesEnum e : PossibleInterfacesEnum.values()) {
            frameLayout.addLayoutComponent(e.getInstance(), e.name());
        }

    }

    public void showInterface(PossibleInterfacesEnum e) {
        frameLayout.show(frame.getContentPane(), e.name());
        if (!frame.isVisible()) {
            frame.setVisible(true);
        }
    }
}