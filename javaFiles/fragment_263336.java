/**
 * Scrolls exactly one Item a time. Works for JTable and JList.
 *
 * @author Lukas Knuth
 * @version 1.0
 */
public class Main {

    private JTable table;
    private JList list;
    private JFrame frame;

    private final String[] data;

    /**
     * This is where the magic with the "just one item per scroll" happens!
     */
    private final AdjustmentListener singleItemScroll = new AdjustmentListener() {
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            // The user scrolled the List (using the bar, mouse wheel or something else):
            if (e.getAdjustmentType() == AdjustmentEvent.TRACK){
                // Jump to the next "block" (which is a row".
                e.getAdjustable().setBlockIncrement(1);
            }
        }
    };

    public Main(){
        // Place some random data:
        Random rnd = new Random();
        data = new String[120];
        for (int i = 0; i < data.length; i++)
            data[i] = "Set "+i+" for: "+rnd.nextInt();
        for (int i = 0; i < data.length; i+=10)
            data[i] = "<html>"+data[i]+"<br>Spacer!</html>";
        // Create the GUI:
        setupGui();
        // Show:
        frame.pack();
        frame.setVisible(true);
    }

    private void setupGui(){
        frame = new JFrame("Single Scroll in Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        frame.add(split);

        // Add Data to the table:
        table = new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return data.length;
            }

            @Override
            public int getColumnCount() {
                return 1;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return data[rowIndex];
            }
        });
        for (int i = 0; i < data.length; i+=10)
            table.setRowHeight(i, 30);
        JScrollPane scroll = new JScrollPane(table);
        // Add out custom AdjustmentListener to jump only one row per scroll:
        scroll.getVerticalScrollBar().addAdjustmentListener(singleItemScroll);
        split.add(scroll);

        list = new JList<String>(data);
        scroll = new JScrollPane(list);
        // Add out custom AdjustmentListener to jump only one row per scroll:
        scroll.getVerticalScrollBar().addAdjustmentListener(singleItemScroll);
        split.add(scroll);
    }

    public static void main(String[] agrs){
        new Main();
    }
}