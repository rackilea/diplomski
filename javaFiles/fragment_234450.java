public class MyChartComposite extends ChartComposite implements KeyListener
{

    public MyChartComposite(Composite comp, int style, JFreeChart chart, 
                                                      boolean useBuffer){
        super(comp, style, chart, useBuffer);
        addSWTListener(this);
    }   

    @Override
    public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
        System.out.print("Key released: " + e.character);

    }

    @Override
    public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
        System.out.print("Key pressed: " + e.character);
    }
}