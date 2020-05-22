public class ProgressExample extends JFrame
{
    public ProgressExample()
    {
        super("Progress Example");

        ProgressSlider mSlider = new ProgressSlider();
        mSlider.setMinimum(0);
        mSlider.setMaximum(100);
        mSlider.setValue(20);
        mSlider.setProgress(50);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(slider);
        getContentPane().add(mSlider);
    }
    public static void main(String args[])
    {
        ProgressExample f = new ProgressExample();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        f.setSize(300, 80);
        f.show();
    }
}