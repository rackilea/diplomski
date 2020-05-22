for (int i = 0; i < 15; i++) // display 15 components
{
    displayNot();
}

cons.gridy++;
cons.gridx = 12; // Based on you conditions in setLocGrid
cons.weightx = 1;
cons.weighty = 1;
JPanel filler = new JPanel();
filler.setOpaque(false);
panelDisplay.add(filler, cons);