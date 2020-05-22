//public class Table8 extends JPanel{
public class Table8 extends ScrollablePanel{

private int iEntries = 1;

public Table8(String strTitle){
    setLayout(new GridBagLayout());
    setScrollableWidth( ScrollablePanel.ScrollableSizeHint.FIT );