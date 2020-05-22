public class BattleShipButton extends JButton {

    private Coordinate coords;
    public BattleShipButton(Coordinates coords) {
        this.coords = coords;  
        setPreferredSize(new Dimension(20, 20));
    }
    public Coordinates getCoordinates() {
        return coords;
    }
}