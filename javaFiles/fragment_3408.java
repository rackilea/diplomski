package sample;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class AppPersonViewer extends TableViewer
{
    public AppPersonViewer(Composite parent, int style) 
    {
        super(parent, style);
        Table table = getTable();
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        table.setLayoutData(gridData);
        createColumns();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        setContentProvider(new AppContentProvider());
    }

    private void createColumns()
    {
        String[] titles = { "First Name", "Second Name", "Age", "Country", "Likes SO" };
        int[] bounds = { 150, 150, 100, 150, 100 };

        TableViewerColumn column = createTableViewerColumn(titles[0], bounds[0], 0);
        column.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof Person)
                    return ((Person)element).getFirst();
                return super.getText(element);
            }
        });

        column = createTableViewerColumn(titles[1], bounds[1], 1);
        column.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof Person)
                    return ((Person)element).getSecond();
                return super.getText(element);
            }
        });

        column = createTableViewerColumn(titles[2], bounds[2], 2);
        column.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof Person)
                    return ""+((Person)element).getAge();
                return super.getText(element);
            }
        });

        column = createTableViewerColumn(titles[3], bounds[3], 3);
        column.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof Person)
                    return ((Person)element).getCountry();
                return super.getText(element);
            }
        });

        column = createTableViewerColumn(titles[4], bounds[4], 4);
        column.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof Person)
                    return ((Person)element).getLikes();
                return super.getText(element);
            }
        });

        column.setEditingSupport(new OptionEditingSupport(this));
    }

    private TableViewerColumn createTableViewerColumn(String header, int width, int idx) 
    {
        TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, idx);
        column.getColumn().setText(header);
        column.getColumn().setWidth(width);
        column.getColumn().setResizable(true);
        column.getColumn().setMoveable(true);

        return column;
    }
}