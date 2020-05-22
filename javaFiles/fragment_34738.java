Intent intent = new Intent();
intent.putExtra("para1","edited_data_1");
intent.putExtra("para2","edited_data_2");
intent.putExtra("para3","edited_data_3");
intent.putExtra("para4","edited_data_4");
setResult(RESULT_OK, intent);        
finish();