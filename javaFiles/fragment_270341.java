import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class SliderMousePressed extends JPanel
{
    public SliderMousePressed()
    {
        JSlider slider = new JSlider(0, 50, 20);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        snapToMouseClick( slider );
    }

    public static void snapToMouseClick(final JSlider slider)
    {
        MouseListener[] ml = slider.getMouseListeners();

        for (MouseListener l : ml)
            slider.removeMouseListener(l);

        MouseMotionListener[] mml = slider.getMouseMotionListeners();

        for (MouseMotionListener l : mml)
            slider.removeMouseMotionListener(l);

        final BasicSliderUI ui = (BasicSliderUI)slider.getUI();

        BasicSliderUI.TrackListener tl = ui.new TrackListener()
        {
            //  Position slider at mouse
            @Override
            public void mouseClicked(MouseEvent e)
            {
                Point p = e.getPoint();
                int value = ui.valueForXPosition(p.x);
                slider.setValue(value);
            }

            // Prevent scrolling while mouse button is held down

            @Override
            public boolean shouldScroll(int dir)
            {
                return false;
            }
        };

        slider.addMouseListener(tl);
        slider.addMouseMotionListener(tl);
    }

    private static void createAndShowUI()
    {

        JFrame frame = new JFrame("SliderMousePressed");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new SliderMousePressed() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}