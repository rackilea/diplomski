case R.id.edit:
    Intent newData = new Intent(Lab8_082588.this, Lab8_082588Edit.class);
    // I hope you implemented the adapter correctly
    Lab8_082588FetchDetails item = (Lab8_082588FetchDetails) getListView().getItemAtPosition(info.position); 
    String startTitle = item.getTitle();
    String startGross = item.getGross();
    String startDate = item.getDate();

    newData.putExtra(Lab8_082588Edit.TITLE_STRING, startTitle);
    newData.putExtra(Lab8_082588Edit.GROSS_STRING, startGross);
    newData.putExtra(Lab8_082588Edit.DATE_STRING, startDate);
    startActivityForResult(newData, Lab8_082588.EDIT_MOVIE);
    return true;