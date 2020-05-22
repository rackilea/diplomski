public ScrollBar(String hOrV, int min, int max, int start)
{
    slider = new JSlider(hOrV.equals("HORIZONTAL") ?
            SwingConstants.HORIZONTAL : SwingConstants.VERTICAL,
        min, mas, start);
}