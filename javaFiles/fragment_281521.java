Component[] components = aPanel.getComponents();
    if(components != null)
    {
        int numComponents = components.length;
        for(int i = 0; i < numComponents; i++)
        {
            Component c = components[i];
            if(c != null)
            {
                if(c instanceof JButton)
                {
                   // Add button to your list
                }
            }
        }
    }