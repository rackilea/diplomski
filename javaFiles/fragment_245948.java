public class ProjectConfigViewer extends TableViewer{

    public ProjectConfigViewer(Composite parent, Text selectProjectPathText,int style) 
    {
        super(parent, style);
        Table table = getTable();
        createColumns(parent, selectProjectPathText);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        //Specify Content provider
        setContentProvider(new ProjectConfigTableContentProvider());
    }

    //Create the columns, column´s label providers and editingsuport to specify how will each column cell be: text column, dialog column...
    private void createColumns(Composite parent,Text selectProjectPathText)
    {   
        String[] COLUMN_HEADINGS = {"Variable", "Path"};

        TableColumnLayout tableLayout = new TableColumnLayout();
        parent.setLayout(tableLayout);

        //Specify first column labelprovider and create it 
        TableViewerColumn variable = createTableViewerColumn(COLUMN_HEADINGS[0], 0);
        variable.getColumn().setResizable(false);
        variable.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof ProjectDirectory && element != null)
                    return ((ProjectDirectory)element).getName();
                return super.getText(element);
            }
        });

         //Specify second column labelprovider and create it
        TableViewerColumn path = createTableViewerColumn(COLUMN_HEADINGS[1], 1);
        path.getColumn().setResizable(false);
        path.setLabelProvider(new ColumnLabelProvider(){
            public String getText(Object element) {
                if(element instanceof ProjectDirectory && element != null)
                    return ((ProjectDirectory)element).getPath();
                return super.getText(element);
            }
        });

        //Spedify the dimensions of each column
        tableLayout.setColumnData(path.getColumn(), new ColumnWeightData(50));
        tableLayout.setColumnData(variable.getColumn(), new ColumnWeightData(50));

        //Specify setEditingSupport for each cell. First cell will be text, second will be a Dialog.
        variable.setEditingSupport(new ProjectConfigVariableEditingSupport(this));
        path.setEditingSupport(new ProjectConfigPathEditingSupport(this, selectProjectPathText));
    }

    //Create tableviewercolumns
    private TableViewerColumn createTableViewerColumn(String header, int idx) 
    {
        TableViewerColumn column = new TableViewerColumn(this, SWT.LEFT, idx);
        column.getColumn().setText(header);
        column.getColumn().setResizable(true);
        column.getColumn().setMoveable(true);

        return column;
    }
}