public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mark_sheet);

            try {
                DisplayMarkSheet(new JSONObject(ReturnJsonData()));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String ReturnJsonData() {

            return "{\"SemisterData\":" +
            //Specify your columns here
            "{\"Columns\":" +
                "[" +
                    "{\"ColumnName\":\"\"}," + //This column is intentionally blank. First Row, First Column will be blank
                    "{\"ColumnName\":\"Semister1\"}," +
                    "{\"ColumnName\":\"Semister2\"}," +
                    "{\"ColumnName\":\"Semister3\"}," +
                    "{\"ColumnName\":\"Semister4\"}," +
                    "{\"ColumnName\":\"Semister5\"}]," +
            "\"FooterRows\":" +
                "[" +
                    "{\"Cells\":" +
                        "[" +
                            "{\"CellValue\":\"Total\"}," +
                            "{\"CellValue\":\"160\"}," +
                            "{\"CellValue\":\"200\"}," +
                            "{\"CellValue\":\"240\"}," +
                            "{\"CellValue\":\"300\"}," +
                            "{\"CellValue\":\"340\"}]}]," +
            "\"Rows\":" + //One row for each subject, Rows will have cells with data
                "[" +
                    "{\"Cells\":" +
                        "[" +
                            "{\"CellValue\":\"Maths\"}," +
                            "{\"CellValue\":\"40\"}," +
                            "{\"CellValue\":\"50\"}," +
                            "{\"CellValue\":\"60\"}," +
                            "{\"CellValue\":\"70\"}," +
                            "{\"CellValue\":\"80\"}]}," +

                    "{\"Cells\":" +
                        "[" +
                            "{\"CellValue\":\"Science\"}," +
                            "{\"CellValue\":\"40\"}," +
                            "{\"CellValue\":\"50\"}," +
                            "{\"CellValue\":\"60\"}," +
                            "{\"CellValue\":\"70\"}," +
                            "{\"CellValue\":\"80\"}]}," +
                    "{\"Cells\":" +
                        "[" +
                            "{\"CellValue\":\"English\"}," +
                            "{\"CellValue\":\"40\"}," +
                            "{\"CellValue\":\"50\"}," +
                            "{\"CellValue\":\"60\"}," +
                            "{\"CellValue\":\"70\"}," +
                            "{\"CellValue\":\"80\"}]}," +
                    "{\"Cells\":" +
                        "[" +
                            "{\"CellValue\":\"Physics\"}," +
                            "{\"CellValue\":\"40\"}," +
                            "{\"CellValue\":\"50\"}," +
                            "{\"CellValue\":\"60\"}," +
                            "{\"CellValue\":\"70\"}," +
                            "{\"CellValue\":\"80\"}]}]}}";
        }

        public TextView GetHeaderTextView(String HeaderText) {
            TextView title = new TextView(this);
            title.setText(HeaderText);
            title.setGravity(Gravity.CENTER);
            title.setTextColor(Color.BLACK);
            title.setTypeface(Typeface.DEFAULT_BOLD);
            title.setBackgroundColor(Color.WHITE);
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            title.setPadding(10, 10, 10, 10);
            return title;
        }

        public TextView GetHeaderTextViewHidden(String HeaderText) {
            TextView title = new TextView(this);
            title.setText(HeaderText);
            title.setGravity(Gravity.CENTER);
            title.setBackgroundColor(Color.parseColor("#A9A9A9"));
            title.setTextColor(Color.BLACK);
            // title.setTextAppearance(context, color.RowText);
            title.setTypeface(Typeface.DEFAULT_BOLD);
            title.setHeight(0);
            title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            title.setPadding(10, 10, 10, 10);
            return title;
        }

        public TextView GetItemTextView(String ItemText, String ColumnAlign) {
            TextView text = new TextView(this);
            text.setText(ItemText);

            if (ColumnAlign.equals("L"))
                text.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            else if (ColumnAlign.equals("R"))
                text.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            else if (ColumnAlign.equals("C"))
                text.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            text.setPadding(10, 10, 10, 10);
            text.setTypeface(Typeface.DEFAULT_BOLD);
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            // text.setCompoundDrawablesWithIntrinsicBounds(0, 0,
            // R.drawable.next_image, 0);
            text.setTextColor(Color.BLACK);

            return text;
        }

        public static TextView GetItemTextViewHidden(Context context, String ItemText, String ColumnAlign) {
            TextView text = new TextView(context);
            text.setText(ItemText);
            if (ColumnAlign.equals("L"))
                text.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            else if (ColumnAlign.equals("R"))
                text.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
            else if (ColumnAlign.equals("C"))
                text.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
            text.setPadding(10, 10, 10, 10);
            text.setTypeface(Typeface.DEFAULT_BOLD);
            text.setHeight(0);
            text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            text.setTextColor(Color.WHITE);
            return text;
        }

        public void DisplayMarkSheet(JSONObject json) throws JSONException {
            TableLayout headerTable = (TableLayout) findViewById(R.id.header);
            TableLayout dataTable = (TableLayout) findViewById(R.id.maintable);

            headerTable.setStretchAllColumns(true);
            dataTable.setStretchAllColumns(true);

            TableRow headerRow = new TableRow(this);
            TableRow invisibleHeaderRow = new TableRow(this);

            JSONArray columnsArray = json.getJSONObject("SemisterData").getJSONArray("Columns");
            JSONArray rowsArray = json.getJSONObject("SemisterData").getJSONArray("Rows");
            JSONArray footerArray = json.getJSONObject("SemisterData").getJSONArray("FooterRows");

            // Create header row and add Columns
            if (json.getJSONObject("SemisterData").isNull("Columns") == false) {
                headerRow.setBackgroundColor(Color.WHITE);
                for (int i = 0; i <= columnsArray.length() - 1; i++) {
                    headerRow.addView(GetHeaderTextView(columnsArray.getJSONObject(i).getString("ColumnName")));
                    invisibleHeaderRow.addView(GetHeaderTextViewHidden(columnsArray.getJSONObject(i).getString("ColumnName")));
                }
                headerTable.addView(headerRow);
                headerTable.addView(invisibleHeaderRow);
            }

            // Create data row and add data
            String headerText = "";
            String rowText;
            if (json.getJSONObject("SemisterData").isNull("Rows") == false) {
                for (int i = 0; i <= rowsArray.length() - 1; i++) {
                    TableRow dataRow = new TableRow(this);
                    TableRow invisibledataRow = new TableRow(this);

                    dataRow.setBackgroundColor(Color.WHITE);

                    int cellsLength = 0;
                    if (rowsArray.getJSONObject(i).isNull("Cells") == false)

                    {
                        cellsLength = rowsArray.getJSONObject(i).getJSONArray("Cells").length();
                        for (int k = 0; k <= cellsLength - 1; k++) {

                            dataRow.addView(GetItemTextView(rowsArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue"), "C"));
                            rowText = rowsArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue");

                            headerText = (String) ((TextView) invisibleHeaderRow.getChildAt(k)).getText();
                            if (headerText.length() > rowText.length())
                                invisibledataRow.addView(GetItemTextViewHidden(this, headerText, "C"));
                            else {
                                invisibledataRow.addView(GetItemTextViewHidden(this, rowsArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue"), "C"));
                                ((TextView) invisibleHeaderRow.getChildAt(k)).setText(rowText);
                            }

                        }
                        dataRow.setPadding(0, 5, 0, 5);
                        dataTable.addView(dataRow);
                        dataTable.addView(invisibledataRow);
                    }
                }

            }

            // Create footer row and populate data
            if (json.getJSONObject("SemisterData").isNull("FooterRows") == false) {
                for (int i = 0; i <= footerArray.length() - 1; i++) {
                    TableRow footerRow = new TableRow(this);
                    footerRow.setBackgroundColor(Color.WHITE);
                    if (footerArray.getJSONObject(i).isNull("Cells") == false) {
                        for (int k = 0; k <= footerArray.getJSONObject(i).getJSONArray("Cells").length() - 1; k++) {
                            footerRow.addView(GetItemTextView(footerArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue"), "C"));
                            footerRow.setPadding(0, 5, 0, 5);

                            if (headerText.length() < footerArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue").length())
                                ((TextView) invisibleHeaderRow.getChildAt(k)).setText(footerArray.getJSONObject(i).getJSONArray("Cells").getJSONObject(k).getString("CellValue"));
                        }
                        dataTable.addView(footerRow);
                    }
                }
            }
        }
}