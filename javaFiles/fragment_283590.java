public static void main(String[] args)
{
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(800, 600);

    JList list = new JList(new Object[]{"111","111","111","111","111","111","111"});
    list.setSelectionModel(new MySelectionModel(list, 3));
    frame.getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);

    frame.setVisible(true);
}

private static class MySelectionModel extends DefaultListSelectionModel
{
    private JList list;
    private int maxCount;

    private MySelectionModel(JList list,int maxCount)
    {
        this.list = list;

        this.maxCount = maxCount;
    }

    @Override
    public void setSelectionInterval(int index0, int index1)
    {
        if (index1 - index0 >= maxCount)
        {
            index1 = index0 + maxCount - 1;
        }
        super.setSelectionInterval(index0, index1);
    }

    @Override
    public void addSelectionInterval(int index0, int index1)
    {
        int selectionLength = list.getSelectedIndices().length;
        if (selectionLength >= maxCount)
            return;

        if (index1 - index0 >= maxCount - selectionLength)
        {
            index1 = index0 + maxCount - 1 - selectionLength;
        }
        if (index1 < index0)
            return;
        super.addSelectionInterval(index0, index1);
    }
}