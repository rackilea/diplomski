final DiscourseManager dM = new DiscourseManager();

java.awt.EventQueue.invokeLater(new Runnable()
{

    public void run()
    {
     DialogueManagerUI.dM = dM;
     new DialogueManagerUI().setVisible(true);
    }
});