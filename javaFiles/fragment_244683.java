import javax.swing.event.EventListenerList;

public class TableComp extends Composite {
    private Table table;

    //Event listener list ===================================
    private EventListenerList listenerList = new EventListenerList();

    public TableComp(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));

        table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn tblclmnColumn = new TableColumn(table, SWT.NONE);
        tblclmnColumn.setWidth(100);
        tblclmnColumn.setText("column1");
    }
    @Override
    protected void checkSubclass() {
    }
    public void updateTable(){
        for (int i = 0; i < 100; i++) {
            TableItem item = new TableItem(table, i);
            item.setText("bla" + i);
        }
        //===================TABLE WAS UPDATED. FIRE EVENT ==================
        fireEvent(new SomethingHappenedEvent("foo"));
    }

    /*
     * ========== Event Handling ==========
     */
    public void addMessageListener(SomethingHappenedListener listener) {
        listenerList.add(SomethingHappenedListener.class, listener);
    }
    public void removeMessageListener(SomethingHappenedListener listener) {
        listenerList.remove(SomethingHappenedListener.class, listener);
    }
    public void fireEvent(SomethingHappenedEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i+2) {
            if (listeners[i] == SomethingHappenedListener.class) {
                ((SomethingHappenedListener) listeners[i+1]).somethingHappened(evt);
            }
        }
    }
}