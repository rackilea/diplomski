import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View {

    public static final String CELL_SELECTION = "cell selection";
    private final static int GAP = 2;
    private static int iconWidth;
    private int rows;

    private JPanel mainPanel;
    private JLabel[][] grid;
    private Map<Token, Icon> iconMap = new EnumMap<>(Token.class);
    private int selectedRow;
    private int selectedCol;

    //a collection of cells representing a path
    private CellsList path;

    //a pane to hold two panels one on top of the other
    JPanel layeredPanel;

    View() {

        mainPanel = new JPanel();

        //add layerd pane to hold two panels one on top of the other
        layeredPanel = new JPanel();

        //set GridBagLayout to allow placing two components one on top of the other
        layeredPanel.setLayout(new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.gridx = 0;
          gbc.gridy = 0;
          gbc.weightx = 1;
          gbc.weighty = 1;
          gbc.fill = GridBagConstraints.BOTH;

        //add main panel to layered panel
        layeredPanel.add(mainPanel, gbc);

        //create and add a drawing panel
        DrawJPanel drawPanel = new DrawJPanel();
        drawPanel.setOpaque(false); //set if to transparent so it does not
                                    //hide mainPanel under it
        layeredPanel.add(drawPanel, gbc);

        //set z-order (depth) of two panels
        layeredPanel.setComponentZOrder(mainPanel,1);
        layeredPanel.setComponentZOrder(drawPanel,0);
    }

    void createGrid(int rows, int cols) {

        MyMouseListener listener = new MyMouseListener();
        setRows(rows);
        setIcons();

        mainPanel.setLayout(new GridLayout(rows, cols, 1, 1));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.setBackground(Color.BLACK);
        grid = new JLabel[rows][cols];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = new JLabel(iconMap.get(Token.VIDE));
                grid[r][c].addMouseListener(listener);
                grid[r][c].setOpaque(true);
                grid[r][c].setBackground(Color.WHITE);
                mainPanel.add(grid[r][c]);
            }
        }

        layeredPanel.setPreferredSize(mainPanel.getPreferredSize());
    }

    int getSelectedRow() {
        return selectedRow;
    }

    int getSelectedCol() {
        return selectedCol;
    }

    void setCell(Token token, int row, int col) {

        grid[row][col].setIcon(iconMap.get(token));
    }

    int getRows() {
        return rows;
    }

    void setRows(int rows) {
        this.rows = rows;
    }

    //added to each cell to listen to mouse clicks
    //fires property change with cell index
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel selection = (JLabel) e.getSource();
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[r].length; c++) {
                    if (selection == grid[r][c]) {
                        selectedRow = r;
                        selectedCol = c;
                        int index = (r * grid[r].length) + c;
                        mainPanel.firePropertyChange(CELL_SELECTION, -1, index);
                    }
                }
            }
        }
    }

    void start() {

        JFrame frame = new JFrame("MVC Pha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(layeredPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //add listener to listen to property changes fired by MyMouseListener
    void addPropertyChangeListener(PropertyChangeListener viewListener) {

        mainPanel.addPropertyChangeListener(viewListener);
    }

    void setPath(CellsList path) {

        this.path = path;
        if(path != null) {
            drawPath();
        }
    }
    //highlight path by changing background color.
    //It can be changed to draw lines between cells
    private void drawPath() {

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                if((path != null) && path.contains(new int[] {row,col})) {
                    grid[row][col].setBackground(Color.YELLOW);
                } else {
                    grid[row][col].setBackground(Color.WHITE);
                }
            }
        }
    }

    //receives rectangle and returns its center point
    private Point getComponentCenter(Rectangle bounds) {

        int xCenter = (int) ((bounds.getX()+ bounds.getMaxX())/2);
        int yCenter  = (int) ((bounds.getMinY()+ bounds.getMaxY())/2);
        return new Point(xCenter, yCenter);
    }

    void refresh() {

        layeredPanel.repaint();
    }

    private void setIcons() {

        if(rows <= 20) {
            iconWidth = 24;
        } else if( rows <= 40 ) {
            iconWidth = 20;
        } else if( rows <= 60 ) {
            iconWidth = 15;
        } else if( rows <= 80 ) {
            iconWidth = 12;
        } else {
            iconWidth = 8;
        }

        iconMap.put(Token.VIDE, createIcon(new Color(0, 0, 0, 0)));
        iconMap.put(Token.CERCLE_BLEU, createIcon(Color.BLUE));
        iconMap.put(Token.CERCLE_ROUGE, createIcon(Color.RED));
    }

    private Icon createIcon(Color color) {

        BufferedImage img = new BufferedImage(iconWidth, iconWidth, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillOval(1, 1, iconWidth - GAP, iconWidth - GAP);
        g2.dispose();

        return new ImageIcon(img);
    }

    //a panel to draw line on
    class DrawJPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g){

            super.paintComponent(g);

            if((path == null) || path.isEmpty() ) {
                return;
            }

            //calculate points to construct line along the path
            Point[] polygon = new Point[path.size()];

            int i=0;
            for(int[] address : path) { //iterate over path

                //get cell location (row / col)
                int row = address[0]; int col = address[1];

                //get label in that location
                JLabel lable = grid[row][col];

                //add center of label as a point in polygon
                polygon[i++] = getComponentCenter(lable.getBounds());
            }

            //draw points in polygon
            g.setColor(Color.CYAN); //set line color and width
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));

            int j;
            for (j = 0; j < (polygon.length -1); j++)       {

                Point point1 = polygon[j];
                Point point2 = polygon[j+1];
                g2.draw(new Line2D.Float(point1, point2));
            }

            //add line to connect last point to first
           g2.draw(new Line2D.Float(polygon[j], polygon[0]));
        }
    }
}