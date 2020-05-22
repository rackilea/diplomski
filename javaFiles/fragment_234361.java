public class UIClass {
    private int number = 42;
    private JPanel jp = new JPanel();

    public UIClass() {
        jp.addMouseListener(new MouseListenerClass(this));
        jp.setName("test");
    }

    public int getNumber() {
        return number;
    }
}

public class MouseListenerClass extends MouseAdapter {
    private UIClass uiclass;

    public MouseListenerClass(UIClass uiclass) {
        this.uiclass = uiclass;
    }

    public void mousePressed(MouseEvent me) {
        JPanel jp1 = (JPanel) me.getSource();
        System.out.println(jp1.getName());
        System.out.println(uiclass.getNumber());
    }
}