public class Expander extends javax.swing.JFrame   
{   
    public Expander()   
    {   
        this.setBounds(0, 0, 300, 300);   
    }   

    public static void main(String args[])   
    {   
        java.awt.EventQueue.invokeLater(new Runnable()   
        {   
            public void run()   
            {   
                new Expander().setVisible(true);   
            }   
        });   
    }   
}