javaaddpath('Path\to\YourJar.jar');
figure();
hTable = uitable('v0', 'data', magic(5), 'position', [5,5,550,400]);
set(hTable, 'Units', 'normalized');
borderColor = java.awt.Color(1,0,0);
renderer = CustomBorderCellRenderer(borderColor);
header = hTable.getTable().getTableHeader();
header.setDefaultRenderer(renderer);