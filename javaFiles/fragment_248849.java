import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class CellNavTest {
    public CellNavTest(Shell shell)
    {
        final TableViewer v = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
        v.setContentProvider(new MyContentProvider());

        TableViewerColumn column = new TableViewerColumn(v, SWT.NONE);
        column.getColumn().setWidth(200);
        column.getColumn().setText("Givenname");
        column.getColumn().setMoveable(true);
        column.setLabelProvider(new ColumnLabelProvider() {

            public String getText(Object element) {
                return ((Person) element).givenname;
            }
        });

        column = new TableViewerColumn(v, SWT.NONE);
        column.getColumn().setWidth(200);
        column.getColumn().setText("Surname");
        column.getColumn().setMoveable(true);
        column.setLabelProvider(new ColumnLabelProvider() {

            public String getText(Object element) {
                return ((Person) element).surname;
            }

        });

        column = new TableViewerColumn(v, SWT.NONE);
        column.getColumn().setWidth(200);
        column.getColumn().setText("E-Mail");
        column.getColumn().setMoveable(true);
        column.setLabelProvider(new ColumnLabelProvider() {

            public String getText(Object element) {
                return ((Person) element).email;
            }

        });

        CellNavigationStrategy naviStrat = new CellNavigationStrategy() 
        {

            @Override
            public boolean isNavigationEvent(ColumnViewer viewer, Event event) {
                return event.keyCode == SWT.CR || event.keyCode == SWT.KEYPAD_CR;
            }

            public ViewerCell findSelectedCell(ColumnViewer viewer, ViewerCell currentSelectedCell, Event event)
            {
                if (event.type == ColumnViewerEditorActivationEvent.KEY_PRESSED) {
                    if (event.keyCode == SWT.CR  || event.keyCode == SWT.KEYPAD_CR) 
                    {
                        ViewerCell nextCell = currentSelectedCell.getNeighbor(ViewerCell.BELOW, false);
                        if(nextCell != null) 
                        {
                            /*
                             * START
                             * Shows the column. If the column is already showing in the receiver, this method simply returns. 
                             * Otherwise, the columns are scrolled until the column is visible. So when you press enter it will just
                             * return the same column index and hence as per javadoc it will just return.
                             */
                            //System.out.println(nextCell.getColumnIndex());
                            //v.getTable().showColumn(v.getTable().getColumn(nextCell.getColumnIndex()));
                            /*
                             * END
                             */

                            if(nextCell.getItem() instanceof TableItem)
                                v.getTable().setSelection(((TableItem)nextCell.getItem()));
                        }
                        return nextCell;
                    }
                }
                return null;
            }

        };

        new TableViewerFocusCellManager(v, new FocusCellOwnerDrawHighlighter(v), naviStrat);    

        Person[] model = createModel();
        v.setInput(model);
        v.getTable().setLinesVisible(true);
        v.getTable().setHeaderVisible(true);
    }

    private Person[] createModel() {
        Person[] elements = new Person[4];
        elements[0] = new Person("Tom", "Schindl",
                "tom.schindl@bestsolution.at", "M");
        elements[1] = new Person("Boris", "Bokowski",
                "Boris_Bokowski@ca.ibm.com","M");
        elements[2] = new Person("Tod", "Creasey", "Tod_Creasey@ca.ibm.com","M");
        elements[3] = new Person("Wayne", "Beaton", "wayne@eclipse.org","M");

        return elements;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = new Display();

        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        new CellNavTest(shell);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        display.dispose();

    }
}

class MyContentProvider implements IStructuredContentProvider {

    public Object[] getElements(Object inputElement) {
        return (Person[]) inputElement;
    }
    public void dispose() {
    }
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}

class Person {
    public String givenname;
    public String surname;
    public String email;
    public String gender;
    public Person(String givenname, String surname, String email, String gender) {
        this.givenname = givenname;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
    }

}