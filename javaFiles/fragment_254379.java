final CharSequence[] Animals= ShowView.toArray(new String[ShowView.size()]);
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setTitle("ListView");
    builder.setItems(Animals, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int item) {
           String val=String.valueOf(Animals[item]);// this is value
        }
    });
    builder.show();