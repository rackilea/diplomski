private void setCB(int index)
    {
        for (int i = 0; i < scrollPaneList.size(); i++)
        {
            scrollPaneList.get(i).setVisible(index == i);
        }      

    }