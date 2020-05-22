public class GeometryCalculator implements ItemListener {

    public void addComponentToPane(Container pane) {

        //...
        calcButton1.addActionListener(new CalcButtonListenerA());
    }

    private class CalcButtonListenerA implements ActionListener
    {
        //...
    }
}