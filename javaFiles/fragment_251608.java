import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TestScrollPane extends JPanel {

    private int w,h;
    private JPanel content;
    private JScrollPane scroll;
    private JButton add;
    private JLabel getTextLabel;
    private JButton getTextBtn;

    /**
     * Create the panel.
     */
    public TestScrollPane(int width, int height) {
        setLayout(null);

        w = width; h = height;

        scroll = new JScrollPane();
        scroll.setBounds(0, 0, w, h);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        content = new JPanel();
        scroll.setViewportView(content);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        add = new JButton("+");
        add.setBounds(0, h, 89, 23);
        add(add);

        getTextLabel = new JLabel("");
        getTextLabel.setBounds(10, 425, 215, 14);
        add(getTextLabel);

        getTextBtn = new JButton("Get Text");
        getTextBtn.setBounds(225, 425, 215, 14);
        getTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a[] = getText(),
                       b = "";
                b += "[";
                for(int i = 0; i < a.length - 1; i++)
                    b += a[i]+", ";
                b += a[a.length-1]+"]";
                System.out.println(b);
                getTextLabel.setText(b);
            }
        });
        add(getTextBtn);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("adding "+content.getComponentCount());
                content.add(new ScrollItem(content.getComponentCount()));
                validate();
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public String[] getText() {
        String out[] = new String[content.getComponentCount()],s;
        for(int i = 0; i < out.length; i++)
            out[i] = (s = ((ScrollItem) content.getComponent(i)).out) == null ? "0" : s;
        return out;
    }

    private class ScrollItem extends JPanel {

        private JTextField text;
        private JButton del;
        private int idx;
        private String out;

        public ScrollItem(int id) {
            idx = id;
            setBounds(0, idx*20, w-5, 20);
            setLayout(null);
            text = new JTextField();
            text.setBounds(0, 0, (w-5)*3/4, 20);
            text.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    out = text.getText();
                }
            });

            AbstractDocument d = (AbstractDocument) text.getDocument();
            d.setDocumentFilter(new TextFilter(4));

            del = new JButton("X");
            del.setBounds((w-5)*3/4, 0, (w-5)/4, 20);
            del.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    content.remove(idx);
                    for(int i = idx; i < content.getComponentCount(); i++)
                        ((ScrollItem) content.getComponent(i)).moveUp();
                    content.validate();
                    content.repaint();
                    System.out.println("Removed "+idx);
                }
            });
            add(text);
            add(del);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(w-5, 20);
        }

        public void moveUp() {
            idx--;
            content.validate();
            content.repaint();
        }
    }

    private class TextFilter extends DocumentFilter {
        private int max;

        public TextFilter(int maxChars) {
            max = maxChars;
        }

        @Override
        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {
            System.out.println("insert");
            if ((fb.getDocument().getLength() + str.length()) <= max && str.matches("\\d+"))
                super.insertString(fb, offs, str, a);
            else
                showError("Length: "+((fb.getDocument().getLength() + str.length()) <= max)+" | Text: "+str.matches("\\d+")+" | Str: "+str);
        }

        @Override
        public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
            System.out.println("replace");
            if ((fb.getDocument().getLength() + str.length() - length) <= max && str.matches("\\d+"))
                super.replace(fb, offs, length, str, a);
            else
                showError("Length: "+((fb.getDocument().getLength() + str.length() - length) <= max)+" | Text: "+str.matches("\\d+")+" | Str: "+str);
        }

        private void showError(String cause) {
            JOptionPane.showMessageDialog(null, cause);
        }
    }
}