import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class TestFrame extends JFrame{

    public TestFrame(){
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void init() {
        JTextField f = new JTextField();
        f.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validate(e);
            }

            private void validate(DocumentEvent e) {
                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    if(text.equals("hello")){
                        System.out.println("ok");
                    }
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        });
        f.setText("hello");
        add(f);
    }

    public static void main(String... s){
        new TestFrame();
    }

}