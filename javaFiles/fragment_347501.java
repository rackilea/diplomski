public final int HORIZONTAL = SwingConstants.HORIZONTAL;
public final int VERTICAL = SwingConstants.VERTICAL;
public ScrollBar(int hOrV, int min, int max, int start)
{
    slider = new JSlider(hOrV, min, mas, start);
}