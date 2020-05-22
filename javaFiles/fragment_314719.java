import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChessLocation extends JPanel {
    public static final String RANK = "rank";
    public static final String FILE = "file";
    public static final String MOUSE_PRESS = "mouse press";
    public static final String PIECE_IMG_PATH = "https://upload.wikimedia.org"
         + "/wikipedia/commons/thumb/b/b2/Chess_Pieces_Sprite.svg" 
         + "/320px-Chess_Pieces_Sprite.svg.png";  // for smaller pieces
    //   + "/640px-Chess_Pieces_Sprite.svg.png"; // for larger pieces
    private static final int IMG_ROWS = 2;
    private static final int IMG_COLS = 6;
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final Color COLOR_LIGHT = new Color(240, 201, 175);
    private static final Color COLOR_DARK = new Color(205, 133, 63);
    private Map<ChessPiece, Icon> pieceIconMap = new HashMap<>();
    private JLabel[][] chessTable = new JLabel[ROWS][COLS];

    public ChessLocation(BufferedImage img) {
        // get chess images and put into pieceIconMap
        int w = img.getWidth() / IMG_COLS;
        int h = img.getHeight() / IMG_ROWS;
        for (int row = 0; row < IMG_ROWS; row++) {
            int y = (row * img.getHeight()) / IMG_ROWS;
            for (int col = 0; col < IMG_COLS; col++) {
                int x = (col * img.getWidth()) / IMG_COLS;
                BufferedImage subImg = img.getSubimage(x, y, w, h);
                Icon icon = new ImageIcon(subImg);

                PieceColor color = PieceColor.values()[row];
                PieceType type = PieceType.values()[col];
                ChessPiece chessPiece = new ChessPiece(type, color);
                pieceIconMap.put(chessPiece, icon);
            }
        }

        // create chess table
        setLayout(new GridLayout(ROWS, COLS));
        Dimension pieceSize = new Dimension(w, h);
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable[i].length; j++) {
                String rank = String.valueOf((char) ('8' - i));
                String file = String.valueOf((char) ('a' + j));
                JLabel label = new JLabel();
                label.setPreferredSize(pieceSize);
                label.setOpaque(true);
                Color c = i % 2 == j % 2 ? COLOR_LIGHT : COLOR_DARK;
                label.setBackground(c);
                label.putClientProperty(RANK, rank);
                label.putClientProperty(FILE, file);
                chessTable[i][j] = label;
                add(label);
            }
        }
        resetBoard();

        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    public void resetBoard() {
        for (JLabel[] row : chessTable) {
            for (JLabel cell : row) {
                cell.setIcon(null);
            }
        }
        chessTable[0][0].setIcon(pieceIconMap.get(new ChessPiece(PieceType.ROOK, PieceColor.BLACK)));
        chessTable[0][7].setIcon(pieceIconMap.get(new ChessPiece(PieceType.ROOK, PieceColor.BLACK)));
        chessTable[7][0].setIcon(pieceIconMap.get(new ChessPiece(PieceType.ROOK, PieceColor.WHITE)));
        chessTable[7][7].setIcon(pieceIconMap.get(new ChessPiece(PieceType.ROOK, PieceColor.WHITE)));

        chessTable[0][1].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KNIGHT, PieceColor.BLACK)));
        chessTable[0][6].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KNIGHT, PieceColor.BLACK)));
        chessTable[7][1].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KNIGHT, PieceColor.WHITE)));
        chessTable[7][6].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KNIGHT, PieceColor.WHITE)));

        chessTable[0][2].setIcon(pieceIconMap.get(new ChessPiece(PieceType.BISHOP, PieceColor.BLACK)));
        chessTable[0][5].setIcon(pieceIconMap.get(new ChessPiece(PieceType.BISHOP, PieceColor.BLACK)));
        chessTable[7][2].setIcon(pieceIconMap.get(new ChessPiece(PieceType.BISHOP, PieceColor.WHITE)));
        chessTable[7][5].setIcon(pieceIconMap.get(new ChessPiece(PieceType.BISHOP, PieceColor.WHITE)));

        chessTable[0][3].setIcon(pieceIconMap.get(new ChessPiece(PieceType.QUEEN, PieceColor.BLACK)));
        chessTable[0][4].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KING, PieceColor.BLACK)));
        chessTable[7][3].setIcon(pieceIconMap.get(new ChessPiece(PieceType.QUEEN, PieceColor.WHITE)));
        chessTable[7][4].setIcon(pieceIconMap.get(new ChessPiece(PieceType.KING, PieceColor.WHITE)));

        // put in pawns
        for (int i = 0; i < PieceColor.values().length; i++) {
            PieceColor color = PieceColor.values()[i];
            ChessPiece piece = new ChessPiece(PieceType.PAWN, color);
            for (int j = 0; j < COLS; j++) {
                int row = 6 - 5 * i;
                chessTable[row][j].setIcon(pieceIconMap.get(piece));
            }
        }
    }

    private class MyMouse extends MouseAdapter {
        String rank = "";
        String file = "";
        Icon icon = null;

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
                return;
            }
            rank = "";
            file = "";
            icon = null;
            Component c = getComponentAt(e.getPoint());
            if (!(c instanceof JLabel)) {
                return;
            }
            JLabel cell = (JLabel) c;
            if (cell.getIcon() == null) {
                return;
            }
            rank = (String) cell.getClientProperty(RANK);
            file = (String) cell.getClientProperty(FILE);
            icon = cell.getIcon();
            // cell.setIcon(null);
        }
    }

    private static void createAndShowGui() {
        BufferedImage img = null;
        try {
            URL imgUrl = new URL(PIECE_IMG_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        ChessLocation chessLocation = new ChessLocation(img);
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chessLocation);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}