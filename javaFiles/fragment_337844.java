TableLayout table = new TableLayout(getApplicationContext());
        table.setColumnStretchable(1, true);
        table.setColumnStretchable(2, true);
        table.setStretchAllColumns(true);

        tableRow = new TableRow[20];
        tableRow[i] = new TableRow(getApplicationContext());
        tableRow[i].setGravity(Gravity.CENTER);
        for (int j = 0; j < 4; j++) {
            statistics = new TextView[4];
            statistics[i] = new TextView(getApplicationContext());
            statistics[i].setText("Text");
            statistics[i].setGravity(Gravity.LEFT);
            tableRow[i].addView(statistics[i]);
        }
        table.addView(tableRow[i]);