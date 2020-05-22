import javax.swing.*;
import java.awt.*;

public class JTableTest extends JFrame {

    private final JTable jTable;

    public JTableTest() throws HeadlessException {
        super("JFrame test");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        final GridBagLayout layout = new GridBagLayout();
        final Container contentPane = this.getContentPane();
        contentPane.setLayout(layout);

        final GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;

        final DtoTableModel<PersonDto> dm = new DtoTableModel<PersonDto>();
        jTable = new JTable(dm);
        dm.addColumn(new PersonDto.NameColumn());
        dm.addColumn(new PersonDto.StreetColumn());
        dm.addRow(new PersonDto(1L, "Paul", "Mayfairy Street"));
        dm.addRow(new PersonDto(2L, "Peter", "Ferdinand Street"));
        JScrollPane scrollpane = new JScrollPane(jTable);
        contentPane.add(scrollpane, gridBagConstraints);

        this.pack();
    }

    public static void main(String[] args) {
        final JTableTest jTableTest = new JTableTest();
        jTableTest.setVisible(true);
    }

}