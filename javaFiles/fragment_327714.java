public interface CardViewChanger {
    public void setCard(String card);
    public void previousCard();
}

public class MainSystem extends JFrame implements CardViewChanger {
    RoomSystem roomPanel = new RoomSystem(this);
    CardLayout layout;

    @Override
    public void setCard(String card) {
        layout.show(this, card);
    }

    @Override
    public void previousCard() {
        layout.next();
    }
}

public class RoomSystem extends JPanel {
    CardViewChanger cardChanger;

    public RoomSystem(CardViewChanger cardChanger) {
        this.cardChanger = cardChanger;

         ...
         public void actionPerformed(ActionEvent e) {
             cardChanger.previousCard();
         }
    } 
}