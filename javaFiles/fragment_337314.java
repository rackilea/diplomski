JPanel wrapper = new JPanel();
JPanel buttons = new JPanel( new GridLayout(0, 4) );

for (...)
{
    JButton button = new JButton(...);
    buttons.add( button );
}

frame.add(wrapper);