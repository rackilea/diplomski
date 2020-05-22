public class PCinterface extends JPanel {

    public HexBoard hexBoard

    public PCinterface(HexBoard board)
    {
        this.hexBoard = board;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int CellCount = this.hexBoard.Cells();
        for (int i = 0; i < this.hexBoard.Cells(); i++) {
            g.drawPolygon(this.hexBoard.GetHexagon(i));
        }
    } // paintBoard

} // PCinterface