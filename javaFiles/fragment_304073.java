package test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class executor extends JFrame {

    String import1 = "java.awt.Robot";
    String import2 = "java.awt.event.KeyEvent";
    String setup1 = "r = new Robot";


    String executionType = "r.keyPress(event)";
    String event = "KeyEvent.VK_4";


    private JTextField textField;

    static ScriptEngineManager manager = new ScriptEngineManager();
    static ScriptEngine engine = manager.getEngineByName("JavaScript");

    public executor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100,100,100,100);

        textField = new JTextField();
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                try {
                    engine.eval("importClass(" + import1 + ")");
                    engine.eval("importClass(" + import2 + ")");

                    engine.eval(setup1);

                    engine.eval(executionType.replaceAll("event", event));

                } catch (ScriptException e) {
                    e.printStackTrace();

                }
            }
        });
        getContentPane().add(textField, BorderLayout.CENTER);
        textField.setColumns(10);
    }

    public static void main(String[] args) {

        executor ex = new executor();
        ex.setVisible(true);
    }
}