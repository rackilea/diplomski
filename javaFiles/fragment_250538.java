public class NinePatchLikePanel extends JPanel{
private JPanel corner_top_l;
private JPanel corner_top_r;
private JPanel corner_bot_l;
private JPanel corner_bot_r;

private JPanel border_ver_l;
private JPanel border_ver_r;
private JPanel border_hoz_t;
private JPanel border_hoz_b;

private int min_width, min_height;

private int corners_width;
private int corners_height;
private int borders_width;
private int borders_height;


public NinePatchLikePanel (String[] urls) {

    if(urls.length != 8) {
        throw new UnsupportedOperationException("Exception to be managed!");
    } else {
        corner_top_l = new JPanelWithBackground (urls [0]);
        corner_top_r = new JPanelWithBackground (urls [1]);
        corner_bot_r = new JPanelWithBackground (urls [2]);
        corner_bot_l = new JPanelWithBackground (urls [3]);

        border_hoz_t = new JPanelWithBackground (urls [4]);
        border_ver_r = new JPanelWithBackground (urls [5]);
        border_hoz_b = new JPanelWithBackground (urls [6]);
        border_ver_l = new JPanelWithBackground (urls [7]);

        corners_width   = corner_top_l.getWidth();
        corners_height  = corner_top_l.getHeight();

        borders_width   = border_hoz_t.getWidth();  
        borders_height  = border_ver_l.getHeight();

        min_width   = 2 * corners_width  + borders_width;
        min_height  = 2 * corners_height + borders_height;

        this.setSize (min_width, min_height );
        this.setMinimumSize ( new Dimension (min_width, min_height) );
        this.setOpaque(false);
        this.setLayout(null);
        this.add(corner_top_l);
        this.add(corner_top_r);
        this.add(corner_bot_l);
        this.add(corner_bot_r);

        this.add(border_hoz_t);
        this.add(border_ver_r);
        this.add(border_hoz_b);
        this.add(border_ver_l);
    }
}

@Override
public void paintComponent(Graphics g)  {
    super.paintComponent(g);

    int actual_width = this.getWidth();
    int actual_height = this.getHeight();

    int _x = actual_width - corners_width;
    int _y = actual_height - corners_height;

    corner_top_l.setLocation(0, 0);
    corner_top_r.setLocation(_x, 0);
    corner_bot_l.setLocation(0, _y);
    corner_bot_r.setLocation(_x, _y);

    int new_borders_width  = _x - corners_width;
    int new_borders_height = _y - corners_height;


    border_hoz_t.setLocation(corners_width, 0);
    border_hoz_t.setSize(new_borders_width, border_hoz_t.getHeight());

    border_ver_r.setLocation(_x, corners_height);
    border_ver_r.setSize(border_ver_r.getWidth(), new_borders_height);

    border_hoz_b.setLocation(corners_width, _y);
    border_hoz_b.setSize(new_borders_width, border_hoz_b.getHeight());

    border_ver_l.setLocation(0, corners_height);
    border_ver_l.setSize(border_ver_l.getWidth(), new_borders_height);
}

}