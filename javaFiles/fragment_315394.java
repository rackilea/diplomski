import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                InputTextView inputView = new InputTextView();
                OutputTextView outputView = new OutputTextView();

                TextModel model = new DefaultTextModel();
                // Shared model!!
                TextController inputController = new DefaultTextController(model, inputView);
                TextController outputController = new DefaultTextController(model, outputView);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(2, 0));
                frame.add(inputView);
                frame.add(outputView);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface TextModel {
        public void setText(String text);
        public String getText();
        public void addChangeListener(ChangeListener listener);
        public void removeChangeListener(ChangeListener listener);
    }

    public interface TextController {
        public String getText();
        public void setText(String text);
    }

    public interface TextView {
        public TextController getController();
        public void setController(TextController controller);
        public void setText(String text);
    }

    public class DefaultTextModel implements TextModel {

        private String text;
        private Set<ChangeListener> listeners;

        public DefaultTextModel() {
            listeners = new HashSet<>(25);
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public void setText(String value) {
            if (text == null ? value != null : !text.equals(value)) {
                this.text = value;
                fireStateChanged();
            }
        }

        @Override
        public void addChangeListener(ChangeListener listener) {
            listeners.add(listener);
        }

        @Override
        public void removeChangeListener(ChangeListener listener) {
            listeners.remove(listener);
        }

        protected void fireStateChanged() {
            ChangeListener[] changeListeners = listeners.toArray(new ChangeListener[0]);
            if (changeListeners != null && changeListeners.length > 0) {
                ChangeEvent evt = new ChangeEvent(this);
                for (ChangeListener listener : changeListeners) {
                    listener.stateChanged(evt);
                }
            }
        }

    }

    public class DefaultTextController implements TextController {

        private TextModel model;
        private TextView view;

        public DefaultTextController(TextModel model, TextView view) {
            this.model = model;
            this.view = view;

            this.view.setController(this);
            this.model.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // You could simply make a "textWasChanged" method on the view
                    // and make the view ask the controller for the value, but where's
                    // the fun in that :P
                    getView().setText(getText());
                }
            });
        }

        public TextModel getModel() {
            return model;
        }

        public TextView getView() {
            return view;
        }

        @Override
        public String getText() {
            return getModel().getText();
        }

        @Override
        public void setText(String text) {
            getModel().setText(text);
        }

    }

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
}