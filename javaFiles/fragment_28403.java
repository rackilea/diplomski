public static void main(String[] args)
{
    SwingUtilities.invokeLater(new Runnable()
    {
        @Override
        public void run()
        {
            Module5 mod5 = new Module5();
            mod5.setVisible(true);
        }
    });
}