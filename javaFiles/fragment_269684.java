@Override
public void stateChanged(ChangeEvent e)
{
    Object source = e.getSource();
    System.out.println(source);
    hasChanged = true;
    if(source instanceof JSlider) {
        panelX.setBorder(new TitledBorder("P0: X = " + ((JSlider) source).getValue());
        update();
    }
}