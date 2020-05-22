ColumnInfo[] columnInfos = new ColumnInfo[] {
    new TreeColumnInfo("Name"),   // <-- This is important!
    new ColumnInfo<Node, String>("Name S1") {
       ...
    }
};