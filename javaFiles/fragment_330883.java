view.setOnLongClickListener((viewL) -> {
    final CharSequence[] optionsDialog = {"Edit", "Delete"};
    ((MainActivity) context).myDialog.setSingleChoiceItems(optionsDialog, 0,
            (DialogInterface dialogInterface, int i) -> {
                if(i==0){
                    final Intent myIntent = new Intent (context, MainInputActivity.class);
                    myIntent.putExtra("request", 8);
                    myIntent.putExtra("oldTask", mySubTask.getSubTaskText());
                    myIntent.putExtra("taskCode", mySubTask.getSubtaskCode());
                    ((MainActivity) context).startActivityForResult(myIntent, 8);
                    dialogInterface.dismiss();
                }
                if(i==1){
                    realm.executeTransaction((realm) -> mySubTask.deleteSubtask());
                    realm.refresh();
                    notifyDataSetChanged();
                    ((MainActivity) context).updateWidgets();
                    dialogInterface.dismiss();
                }     
            });
        });