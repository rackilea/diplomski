public static void main(String args[]) 
{
    final DiscourseManager dM = new DiscourseManager();

    java.awt.EventQueue.invokeLater(new Runnable()
    {

        public void run()
        {
         new DialogueManagerUI(dM).setVisible(true);
        }
    });