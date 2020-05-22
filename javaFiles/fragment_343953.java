public test2()
{
    slider1 = new JSlider(JSlider.VERTICAL, 0, 50, 0);
    setLayout(new FlowLayout(FlowLayout.TRAILING));
    slider1.setMajorTickSpacing( 5 );
    slider1.setPaintLabels( true );
    this.getContentPane().add(slider1);
}