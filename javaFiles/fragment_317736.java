import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthStyle;
import javax.swing.plaf.synth.SynthStyleFactory;

import sun.swing.plaf.synth.DefaultSynthStyle;

public class LnFTest {

    public static void main(String[] args) throws UnsupportedLookAndFeelException{

        SynthLookAndFeel laf = new SynthLookAndFeel();
        laf.load(LnFTest.class.getResourceAsStream("laf.xml"), LnFTest.class);
        UIManager.setLookAndFeel(laf);
        SynthLookAndFeel.setStyleFactory(new MyStyleFactory(SynthLookAndFeel.getStyleFactory()));


        JButton button = new JButton("Test");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Action Performed");
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.CENTER);
        frame.pack();

        frame.setVisible(true);

    }



}

class MyStyleFactory extends SynthStyleFactory {

    private SynthStyleFactory delegate;
    private Map overrides;

     public MyStyleFactory(SynthStyleFactory delegate){
         this.delegate = delegate;

         overrides = new HashMap();
         overrides.put("Button.focusInputMap", new UIDefaults.LazyInputMap(new Object[0]));
     }

     public SynthStyle getStyle(JComponent c, Region id) {
         SynthStyle style = delegate.getStyle(c, id);

         System.out.println("Style is a: " + style);

         if(style instanceof DefaultSynthStyle){
             ((DefaultSynthStyle)style).setData(overrides);
         }

         return style;

     }
}