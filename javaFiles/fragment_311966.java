import javax.swing.JFrame;
    import javax.swing.SwingUtilities;


    public class MainClass 
    {
        /**
         * Main method of this application
         */
        public static void main(final String[] arg)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new PanelWithButton());
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                }
            });
        }
    }