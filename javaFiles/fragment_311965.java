import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelWithButton extends JPanel
{
    // Field members
    private AtomicBoolean paused;
    private JTextArea textArea;
    private JButton button;
    private Thread threadObject;

    /**
     * Constructor
     */
    public PanelWithButton()
    {
        paused = new AtomicBoolean(false);
        textArea = new JTextArea(5, 30);
        button = new JButton();

        initComponents();
    }

    /**
     * Initializes components
     */
    public void initComponents()
    {
        // Construct components
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add( new JScrollPane(textArea));
        button.setPreferredSize(new Dimension(100, 100));
        button.setText("Pause");
        button.addActionListener(new ButtonListener());
        add(button);

        // Runnable that continually writes to text area
        Runnable runnable = new Runnable()
        {
            @Override
            public void run() 
            {
                while(true)
                {
                    for(int i = 0; i < Integer.MAX_VALUE; i++)
                    {
                        if(paused.get())
                        {
                            synchronized(threadObject)
                            {
                                // Pause
                                try 
                                {
                                    threadObject.wait();
                                } 
                                catch (InterruptedException e) 
                                {
                                }
                            }
                        }

                        // Write to text area
                        textArea.append(Integer.toString(i) + ", ");


                        // Sleep
                        try 
                        {
                            Thread.sleep(500);
                        } 
                        catch (InterruptedException e) 
                        {
                        }
                    }
                }
            }
        };
        threadObject = new Thread(runnable);
        threadObject.start();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(400, 200);
    }

    /**
     * Button action listener
     * @author meherts
     *
     */
    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            if(!paused.get())
            {
                button.setText("Start");
                paused.set(true);
            }
            else
            {
                button.setText("Pause");
                paused.set(false);

                // Resume
                synchronized(threadObject)
                {
                    threadObject.notify();
                }
            }
        }
    }
}