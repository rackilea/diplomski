SliderChangeListener listener = new SliderChangeListener();

for(int i=1; i<=numinputed; i++)
{
    slider[i] = new JSlider();
    slider[i].addChangeListener(listener);
}