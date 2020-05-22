Import for TableRowParam
      //  import android.widget.TableRow.LayoutParams;    


       @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text);

            TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);

    TableRow rows = new TableRow(this);
    TableLayout.LayoutParams tableRowParamss=
            new TableLayout.LayoutParams
                 (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);

    rows.setBackgroundColor(Color.parseColor("#62b0ff"));
    tableRowParamss.setMargins(0, 0, 0, 40);
    rows.setLayoutParams(tableRowParamss);

    Button ib = new Button(this);
    //ib.setBackgroundResource(R.drawable.accept);
            // import android.widget.TableRow.LayoutParams;

    LayoutParams rowParam = new LayoutParams(150, LayoutParams.WRAP_CONTENT);
     ib.setLayoutParams(rowParam);

     rows.addView(ib);

     table.addView(rows);


}



 <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:gravity="center"
  android:orientation="vertical" >

    <TableLayout
       android:id="@+id/tableLayout1"
       android:layout_width="match_parent"
       android:layout_height="wrap_content" >

    </TableLayout>

</LinearLayout>