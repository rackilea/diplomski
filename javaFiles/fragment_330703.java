class BoardPanel extends JPanel
{
    public static final int LENGTH = 6;
    private final Color[] COLOR_ARRAY = {Color.decode("#FFFACD"), Color.decode("#593E1A")};

    public BoardPanel()   {
        //grid layout 6x6
        setLayout(new GridLayout(LENGTH, LENGTH));
        int numView = 1;

        for (int i = 0; i < LENGTH; i++)
        {
            numView = (numView == 0) ? 1:0;
            for (int j = 0; j < LENGTH; j++)
            {
                add(new TileView(COLOR_ARRAY[numView]));
                numView = (numView == 0) ? 1:0;
            }
        }
    }
}

class TileView extends JLabel {

    TileView(Color color) {
        setPreferredSize(new Dimension(100,100));
        setOpaque(true);
        setBackground(color);
    }
}