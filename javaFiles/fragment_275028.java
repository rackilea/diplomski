[OperationContract]
[WebInvoke]
public DataTable GetMyDataTable(DataTable dt)
        {
            DataTable returnTable  = new DataTable("ServerTable");
            returnTable.Columns.Add(new DataColumn() { ColumnName = "FirstName", DataType = typeof(String)});
            returnTable.Columns.Add(new DataColumn() { ColumnName = "LastName", DataType = typeof(String) });

            if (dt.Columns.Count == 2 && dt.Rows.Count > 0)
            {
                return returnTable;
            }
            else
            {
                returnTable.Columns.Add(new DataColumn() { ColumnName = "MiddleName", DataType = typeof(String) });
                return returnTable;
            }
        }