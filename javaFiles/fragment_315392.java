public class InputTextView extends JPanel implements TextView {

    private TextController controller;

    public InputTextView() {
        setLayout(new GridBagLayout());
        JTextField field = new JTextField(10);
        add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getController().setText(field.getText());
            }
        });
    }

    @Override
    public TextController getController() {
        return controller;
    }

    @Override
    public void setController(TextController controller) {
        this.controller = controller;
    }

    @Override
    public void setText(String text) {
        // We kind of don't care, because we're responsible for changing the
        // text anyway :P
    }

}

public class OutputTextView extends JPanel implements TextView {

    private TextController controller;

    public OutputTextView() {
    }

    @Override
    public TextController getController() {
        return controller;
    }

    @Override
    public void setController(TextController controller) {
        this.controller = controller;
    }

    @Override
    public void setText(String text) {
        revalidate();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(200, 40);
        TextController controller = getController();
        if (controller != null) {
            String text = controller.getText();
            FontMetrics fm = getFontMetrics(getFont());
            if (text == null || text.trim().isEmpty()) {
                size.width = fm.stringWidth("M") * 10;
            } else {
                size.width = fm.stringWidth(text);
            }
            size.height = fm.getHeight();
        }
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        TextController controller = getController();
        String text = "";
        if (controller != null) {
            text = controller.getText();
        }
        if (text == null) {
            text = "";
        }
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.drawString(text, x, y);
    }

}