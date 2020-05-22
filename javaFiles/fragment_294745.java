/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
/// Implement selection using "adding" only logic. //
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////

@Override
public void setSelectionPath(TreePath path) {

    System.out.println("MLDebugJTree: setSelectionPath(" + path + ")");

    addSelectionPath(path);

    return;
    //super.setSelectionPath(path);
}

@Override
public void setSelectionPaths(TreePath[] paths) {

    System.out.println("MLDebugJTree: setSelectionPaths(" + paths + ")");

    addSelectionPaths(paths);

    return;
}

@Override
public void setSelectionRow(int row) {

    System.out.println("MLDebugJTree: setSelectionRow(" + row + ")");

    addSelectionRow(row);

    return;
    //super.setSelectionRow(row);
}

@Override
public void setSelectionRows(int[] rows) {

    System.out.println("MLDebugJTree: setSelectionRows(" + rows + ")");

    addSelectionRows(rows);

    return;
    //super.setSelectionRows(rows);
}