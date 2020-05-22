void refresh() {
        tableLayout.removeAllViews();
        TableRow[] tableRows = new TableRow[y];
        editTexts = new EditText[y][x];
        for (int i = 0; i < tableRows.length; i++) {
            tableRows[i] = new TableRow(getContext());
            tableLayout.addView(tableRows[i]);
            for (int j = 0; j < editTexts[i].length; j++) {
                editTexts[i][j] = new EditText(getContext());
                editTexts[i][j].setPadding(10, 0, 10, 0);
                editTexts[i][j].setLayoutParams(new 
                TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 
                ViewGroup.LayoutParams.WRAP_CONTENT));
                editTexts[i][j].setBackground(getResources().getDrawable(shape, Objects.requireNonNull(getActivity()).getApplicationContext().getTheme()));
                editTexts[i][j].setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                editTexts[i][j].setMinEms(1);
                editTexts[i][j].setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
                tableRows[i].addView(editTexts[i][j]);
            }
        }
    }