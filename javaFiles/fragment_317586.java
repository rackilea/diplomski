public class DataGridActivity extends Activity {
    /** Called when the activity is first created. */
    ConnectionClass connectionClass;
    //define column
    DataTable.DataRow drRow;
    DataTable dtDataSource = new DataTable();
    Button btnsearch;
    DataGrid dg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.datagridt);
        dg = (DataGrid)findViewById(R.id.datagrid);
        btnsearch = (Button) findViewById(R.id.btnsearch);
        connectionClass = new ConnectionClass(this.getApplicationContext());


        /**
         *  Prepare the DataGrid
         */
        //initialize DataGrid
        //define column style, bond each DataGrid column by DataTable column
                dg.addColumnStyles(new DataGrid.ColumnStyle[]{
                new DataGrid.ColumnStyle(getString(R.string.dito_nr), "column_1", 80),
                new DataGrid.ColumnStyle(getString(R.string.Biltype), "column_2", 120),
                new DataGrid.ColumnStyle(getString(R.string.kort_nr), "column_3", 100),
                new DataGrid.ColumnStyle(getString(R.string.Del_Type), "column_4", 150)

        });

    }


    public class Itemnumber extends AsyncTask<String,String,String> {
        String z = "";
        @Override
        protected void onPreExecute() {
            dtDataSource.addAllColumns(new String[]{"column_1", "column_2","column_3", "column_4"});
            drRow = dtDataSource.newRow();
            dtDataSource.add(drRow);
            dg.setDataSource(dtDataSource);
            dg.refresh();
        }
        @Override
        protected void onPostExecute(String r) {
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    PreparedStatement preparedStatement = null;
                    String sqli = "select ID,ItemNumber,Trashed,Sold from [file].[Item]";
                    preparedStatement = con.prepareStatement(sqli);
                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        //create DataRow
                        drRow.set("column_1", rs.getString(1));
                        drRow.set("column_2", rs.getString(2));
                        drRow.set("column_3", rs.getString(3));
                        drRow.set("column_4", rs.getString(4));

                    } else {
                    }

                }
            } catch (Exception ex) {
                z = "Exceptions";
            }
            return z;

        }
    }

    public void btnsearch (View view) {
        // TODO Auto-generated method stub

        Itemnumber item = new Itemnumber();
        item.execute("");
    }
}