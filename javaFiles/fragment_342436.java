import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewJFrame extends javax.swing.JFrame 
{

    /** Creates new form NewJFrame */
    public NewJFrame() 
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        jTextField1 = new JTextField(10);
        contentPane.add(jTextField1, BorderLayout.PAGE_START);

        jProgressBar1 = new JProgressBar(0, 100);       
        contentPane.add(jProgressBar1, BorderLayout.CENTER);

        jButton1 = new JButton("START");
        jButton1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me)
            {
                jProgressBar1.setIndeterminate(true);
                jButton1MouseClicked(me);
            }
        });
        contentPane.add(jButton1, BorderLayout.PAGE_END);

        setContentPane(contentPane);
        pack();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")   
    public void progress(final int y)
    {
        System.out.println("progress Method is working.");
        /*
         * This thing needs to be done on Event
         * Dispatcher Thread.
         */
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                jTextField1.setText(y+"packets processed");
                System.out.println(y);
            }           
        });         
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) 
    {    
        NewClass m=new NewClass(this);
        m.execute();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {         
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}

class NewClass extends SwingWorker<Void, Void>
{
    public static int counter = 0;
    // Added this variable to keep the instance.
    private NewJFrame p;
    private boolean flag = true;

    public NewClass(NewJFrame frame)
    {
        p = frame;
    }

    public Void doInBackground()
    {
        while(flag)
        {
            counter = counter + 1;
            counter2(counter);
        }
        return null;
    }

    public void done()
    {
        System.out.println("I am DONE");
    }

    public void counter2(int counter) 
    {
        counter3();
    }

    public void counter3() 
    {
        p.progress(counter);
    }
}