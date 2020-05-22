import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;

public class JWidget extends JPanel {

    private boolean showWidgetIcon = true;

    private BasicButton button = new BasicButton(null, 50);

    public JWidget() {
        this(new ImageIcon("src/main/resources/Icon-Settings.png"));
    }

    public JWidget(String filename) {
        super(new BorderLayout());

        ImageIcon icon = new ImageIcon(filename);
        button.setIcon(icon);
        initLayout();
    }

    public JWidget(ImageIcon icon) {
        super(new BorderLayout());
        button.setIcon(icon);
        initLayout();
    }

    private void initLayout() {
        removeAll();
        if (showWidgetIcon) {
            JPanel rightLayoutPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
            add(rightLayoutPanel, BorderLayout.NORTH);
            rightLayoutPanel.add(button);
        }
    }

    public int getWidgetSize() {
        return button.getButtonSize();
    }

    public void setWidgetSize(int widgetSize) {
        button.setButtonSize(widgetSize);
        revalidate();
        repaint();
    }

    public void setImageIcon(ImageIcon icon) {
        button.setIcon(icon);
    }

    public boolean isWidgetIconVisible() {
        return showWidgetIcon;
    }

    public void setShowWidgetVisibility(boolean showWidgetIcon) {
        this.showWidgetIcon = showWidgetIcon;
        initLayout();
    }

    public void addActionListener(ActionListener al) {
        button.addActionListener(al);
    }

    private static class BasicButton extends JButton {
        private int buttonSize;

        /**
         * 
         */
        public BasicButton(Icon anIcon, int aSize) {
            super(anIcon);
            buttonSize = aSize;
        }

        @Override
        public void updateUI() {
            setUI(new BasicButtonUI());
            setBorder(null);
            setContentAreaFilled(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(buttonSize, buttonSize);
        }

        public int getButtonSize() {
            return buttonSize;
        }

        public void setButtonSize(int size) {
            this.buttonSize = size;
        }
    }
}