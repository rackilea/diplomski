import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TestApplication extends JApplet {

private static final long serialVersionUID = 1L;

    JPanel p1,p2;

    @Override
    public void init(){         
        setLayout(new BorderLayout());

        p1=new JPanel();
        p2=new JPanel();

        p1.setBackground(Color.RED);
        p2.setBackground(Color.GREEN);
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.setResizeWeight(0.7);
        sp.setEnabled(false);
        sp.setDividerSize(0);

        sp.add(p1);
        sp.add(p2);
        add(sp, BorderLayout.CENTER);
    }   
}