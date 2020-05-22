import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class CheckBoxDemo {

    static class Foo {
        private boolean visible;
        private String name;

        public Foo(String name) {
            this.name = name;
        }

        public boolean isVisible() {
            return visible;
        }

        public void setVisible(boolean visible) {
            this.visible = visible;
            System.out.println(getName() + ".setVisible:" + visible);
        }

        public String getName() {
            return name;
        }
    }

    static class FooAction extends AbstractAction {
        private Foo foo;

        public FooAction(Foo foo) {
            super(foo.getName());
            this.foo = foo;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            foo.setVisible(checkBox.isSelected());
        }
    }

    private static void createAndShowGUI() {
        List<Foo> fooList = new ArrayList<Foo>();
        fooList.add(new Foo("Foo1"));
        fooList.add(new Foo("Foo2"));
        fooList.add(new Foo("Foo3"));

        JPanel content = new JPanel(new BorderLayout());

        JPanel fooPanel = new JPanel();
        for (Foo foo : fooList) {
            fooPanel.add(new JCheckBox(new FooAction(foo)));
        }

        content.add(fooPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        content.add(scrollPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(content);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        // just for brevity of example
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        }));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}