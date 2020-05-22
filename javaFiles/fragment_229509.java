checkBox.addItemListener(new ItemListener()
{
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            test.get(tabbedPane.indexOfTab(tabName)).setSkipped(true);
        }

        if(e.getStateChange() == ItemEvent.DESELECTED)
        {
            test.get(tabbedPane.indexOfTab(tabName)).setSkipped(false);
        }

        for(int j = 0, k = 1; j < test.size(); j++)
        {
            if(test.get(j).isSkipped())
            {
                continue;
            }

            test.get(j).setLabel("" + k);
            k++;
        }
    }
});