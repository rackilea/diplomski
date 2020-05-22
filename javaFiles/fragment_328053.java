// just for fun, have root items with some graphic
final CheckBoxTreeItem<Employee> root = new CheckBoxTreeItem<>(
        new Employee("Sales Department", 0.0), new Circle(10, Color.RED));
final CheckBoxTreeItem<Employee> root2 = new CheckBoxTreeItem<>(
        new Employee("Departments", 0.0), new Circle(10, Color.BLUE));

// configure treeTableView to use the extended tableRow 
treeTableView.setRowFactory(item -> new CheckBoxTreeTableRow<>());

// configure table columns to use the extended table cell
empColumn.setCellFactory(p -> new DefaultTreeTableCell<>());
// all cell types must have a skin that copes with row graphics
salaryColumn.setCellFactory(e -> {
    TreeTableCell cell = new ProgressBarTreeTableCell() {

        @Override
        protected Skin<?> createDefaultSkin() {
            return new DefaultTreeTableCell.DefaultTreeTableCellSkin<>(this);
        }

    };
    return cell;
});