public static void main(String[] args) {

        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Image pencil = toolKit.getImage("pencil.gif");
        Cursor cursor = toolKit.createCustomCursor(pencil, new Point(0, 0), "Pencil");

        JFrame frame = new JFrame("Cursor Test");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setCursor(cursor);
        frame.setVisible(true);

    }