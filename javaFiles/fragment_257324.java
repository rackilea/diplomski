private void addTableHeader(String title, int colWidth, TableRow headerrow) {

    TextView textview = new TextView(this);
    textview.setText(title);
    textview.setLayoutParams(new android.widget.TableRow.LayoutParams(colWidth, android.widget.TableRow.LayoutParams.WRAP_CONTENT));
    headerrow.addView(textview);

    View v = new View(this);
    v.setLayoutParams(new TableRow.LayoutParams(3, TableRow.LayoutParams.MATCH_PARENT));
    v.setBackgroundColor(Color.RED);
    headerrow.addView(v);
}