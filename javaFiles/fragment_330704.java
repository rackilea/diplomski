import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Chess extends JFrame {

    public Chess()  {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add( new BoardPanel());          //add underlaying board
        setGlassPane(new PiecesPanel()); //add glass pane
        getGlassPane().setVisible(true);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        new Chess();
    }
}

class BoardPanel extends JPanel {

    public static final int LENGTH = 6;
    private final Color[] COLOR_ARRAY = {Color.decode("#FFFACD"), Color.decode("#593E1A")};

    public BoardPanel()   {
        //grid layout 6x6
        setLayout(new GridLayout(LENGTH, LENGTH));
        int numView = 1;
        //tiles color determined by odd/even
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

//container for pieces
class PiecesPanel extends JPanel {

    public static final int LENGTH = 6;
    PiecesPanel(){

        setOpaque(false); //make it transparent
        setLayout(new GridLayout(LENGTH, LENGTH));
        JComponent piece = new Piece();
        add(piece);
    }
}

class TileView extends JLabel {

    public static final int SIZE = 100;
    TileView(Color color) {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setOpaque(true);
        setBackground(color);
    }
}

class Piece extends JLabel{

    Piece() {

        URL url = null;
        try {
            url = new URL("https://dl1.cbsistatic.com/i/r/2017/08/15/9b37ca73-de21-4998-ae7a-07d2915a551e/thumbnail/64x64/0cd91f1c045919af6bdafab3a6f07f99/imgingest-6339051052035379444.png");
        } catch (MalformedURLException ex) { ex.printStackTrace();  }
        setIcon(new ImageIcon(url));
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
    }
}