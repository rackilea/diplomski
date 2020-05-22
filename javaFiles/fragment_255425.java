hobby.putExtra(TITLE_STRING, title);
    hobby.putExtra(GROSS_STRING, gross);
    hobby.putExtra(DATE_STRING, date);
    hobby.putExtra("PASSED_ROW", rowNumber);
    setResult(RESULT_OK, hobby);
    finish();