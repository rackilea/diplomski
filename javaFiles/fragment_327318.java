case R.id.action_delete:
        for(int i = 0; i < arrayTasks.size();i++){
            if((CheckBox)listviewTasks.getChildAt(i).findViewById(R.id.selected) != null){

                CheckBox cBox=(CheckBox)listviewTasks.getChildAt(i).findViewById(R.id.selected);

                if(cBox.isChecked()){
                    dbHelper.deleteTask((int)adapter.getItemId(i));
                }
             }
            }  
        adapter.notifyDataSetChanged();
        return true;