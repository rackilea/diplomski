import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TurnManager implements ActionListener{

    int passFlag = 0;
    int TurnFlag = 0;
    Sentinel sentinel = new Sentinel();
    Player player1,player2;


    public TurnManager(MainFrame mainframe, Table table, Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        for (int i = 0; i < table.getSize(); i++) {
            for (int j = 0; j < table.getSize(); j++) {
                table.getField(i, j).addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Field) {
            Field field = ((Field) e.getSource());
            //implement logic here, for example:
            if (table.isFull())
                throw new RuntimeException("Table full! Stop! STOP!");

            if (player1.isActive())
                field.changeToBlack();
            if (player2.isActive())
                field.changeToBlack();
        }
    }
}