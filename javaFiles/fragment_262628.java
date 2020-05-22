public class AddRowAction extends AbstractAction
    {

        public AddRowAction()
        {
            super("+");
        }

        public void actionPerformed(ActionEvent e)
        {
            parent.cloneRow(Row.this);

            ((JFrame) SwingUtilities.getRoot(parent)).pack(); // <--- THIS LINE
        }
    }

    public class RemoveRowAction extends AbstractAction
    {

        public RemoveRowAction()
        {
            super("-");
        }

        public void actionPerformed(ActionEvent e)
        {
            parent.removeItem(Row.this);

            ((JFrame) SwingUtilities.getRoot(parent)).pack(); // <--- THIS LINE
        }
    }