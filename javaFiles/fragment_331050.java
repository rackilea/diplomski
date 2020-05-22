import javax.swing.*;

public class JCustomTable extends JTable {
    public JCustomTable(/* parameters of your desired JTable constructor */){
        super(/* parameters of your desired JTable constructor */);
        //setting desired global table properties
        setRowHeight(45);
        setShowVerticalLines(false);
    }
}