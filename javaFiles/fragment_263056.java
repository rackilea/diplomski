public class ActiveJComponentTableMouseListener extends MouseAdapter implements MouseMotionListener {

private JTable table;
private JComponent oldComponent = null;
private TableCell oldTableCell = new TableCell();

public ActiveJComponentTableMouseListener(JTable table) {
    this.table = table;
}

@Override
public void mouseMoved(MouseEvent e) {
    TableCell cell = new TableCell(getRow(e), getColumn(e));

    if (alreadyVisited(cell)) {
        return;
    }
    save(cell);

    if (oldComponent != null) {
        dispatchEvent(createMouseEvent(e, MouseEvent.MOUSE_EXITED), oldComponent);
        oldComponent = null;
    }

    JComponent component = getComponent(cell);
    if (component == null) {
        return;
    }
    dispatchEvent(createMouseEvent(e, MouseEvent.MOUSE_ENTERED), component);
    saveComponent(component);
    save(cell);
}

@Override
public void mouseExited(MouseEvent e) {
    TableCell cell = new TableCell(getRow(e), getColumn(e));

    if (alreadyVisited(cell)) {
        return;
    }
    if (oldComponent != null) {
        dispatchEvent(createMouseEvent(e, MouseEvent.MOUSE_EXITED), oldComponent);
        oldComponent = null;
    }
}

@Override
public void mouseEntered(MouseEvent e) {
    forwardEventToComponent(e);
}

private void forwardEventToComponent(MouseEvent e) {
    TableCell cell = new TableCell(getRow(e), getColumn(e));
    save(cell);
    JComponent component = getComponent(cell);
    if (component == null) {
        return;
    }
    dispatchEvent(e, component);
    saveComponent(component);
}

private void dispatchEvent(MouseEvent componentEvent, JComponent component) {
    MouseEvent convertedEvent = (MouseEvent) SwingUtilities.convertMouseEvent(table, componentEvent, component);
    component.dispatchEvent(convertedEvent);
    // This is necessary so that when a button is pressed and released
    // it gets rendered properly.  Otherwise, the button may still appear
    // pressed down when it has been released.
    table.repaint();
}

private JComponent getComponent(TableCell cell) {
    if (rowOrColumnInvalid(cell)) {
        return null;
    }
    TableCellRenderer renderer = table.getCellRenderer(cell.row, cell.column);

    if (!(renderer instanceof ActiveJComponentTableCellRenderer)) {
        return null;
    }
    ActiveJComponentTableCellRenderer activeComponentRenderer = (ActiveJComponentTableCellRenderer) renderer;

    return activeComponentRenderer.getComponent(cell);
}

private int getColumn(MouseEvent e) {
    TableColumnModel columnModel = table.getColumnModel();
    int column = columnModel.getColumnIndexAtX(e.getX());
    return column;
}

private int getRow(MouseEvent e) {
    int row = e.getY() / table.getRowHeight();
    return row;
}

private boolean rowInvalid(int row) {
    return row >= table.getRowCount() || row < 0;
}

private boolean rowOrColumnInvalid(TableCell cell) {
    return rowInvalid(cell.row) || columnInvalid(cell.column);
}

private boolean alreadyVisited(TableCell cell) {
    return oldTableCell.equals(cell);
}

private boolean columnInvalid(int column) {
    return column >= table.getColumnCount() || column < 0;
}

private MouseEvent createMouseEvent(MouseEvent e, int eventID) {
    return new MouseEvent((Component) e.getSource(), eventID, e.getWhen(), e.getModifiers(), e.getX(), e.getY(), e.getClickCount(), e.isPopupTrigger(), e.getButton());
}
private void save(TableCell cell) {
    oldTableCell = cell;
}

private void saveComponent(JComponent component) {
    oldComponent = component;
}}


public class TableCell {

public int row;
public int column;

public TableCell() {
}

public TableCell(int row, int column) {
    this.row = row;
    this.column = column;
}

@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final TableCell other = (TableCell) obj;
    if (this.row != other.row) {
        return false;
    }
    if (this.column != other.column) {
        return false;
    }
    return true;
}

@Override
public int hashCode() {
    int hash = 7;
    hash = 67 * hash + this.row;
    hash = 67 * hash + this.column;
    return hash;
}}

public class ActiveJComponentTableCellRenderer<T extends JComponent> extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

private Map<TableCell, T> components;
private JComponentFactory<T> factory;

public ActiveJComponentTableCellRenderer() {
    this.components = new HashMap<TableCell, T>();        
}

public ActiveJComponentTableCellRenderer(JComponentFactory<T> factory) {
    this();
    this.factory = factory;
}

public T getComponent(TableCell key) {
    T component = components.get(key);
    if (component == null && factory != null) {
        // lazy-load component
        component = factory.build();
        initialiseComponent(component);
        components.put(key, component);
    }
    return component;
}

/**
 * Override this method to provide custom component initialisation code
 * @param component passed in component from getComponent(cell)
 */
protected void initialiseComponent(T component) {
}

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    return getComponent(new TableCell(row, column));
}

@Override
public Object getCellEditorValue() {
    return null;
}

@Override
public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    return getComponent(new TableCell(row, column));
}

public void setComponentFactory(JComponentFactory factory) {
    this.factory = factory;
}}

public interface JComponentFactory<T extends JComponent> {
T build();
}