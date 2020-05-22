public void actionPerformed(ActionEvent e)
{
    // get all components of the panel
    Component[] comp = panel.getComponents();

    // loop through all components
    for (int i = 0; i < comp.length; i++)
    {
        // if it's a button...
        if (comp[i] instanceof JButton)
        {
            JButton b = (JButton) comp[i];

            // if b is a neighbor of button (e.g. the one clicked),
            // then change its background color
            // I leave this logic to you (seems like you wrote most if it already)

            // Hint: Convert the text of b to an int and convert the
            // text of button to an int and compare the ints to see if 
            // they are neighbors. You can convert the int of 
            // button.getText once outside of the loop. No sense in 
            // doing the conversion every time since it will be the same.
        }

    }

    // Rest of code in your actionPerformed method...

}