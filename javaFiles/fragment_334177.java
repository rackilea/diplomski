private void setupListViewListener() {
        list.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapter,
                                               View item, int pos, long id) {

                    String title_of_row_to_delete = list.getItemAtPosition(i).toString(); //<<<<<<<<
                    // Remove the item within array at position
                    items.remove(pos);
                    // Refresh the adapter
                    SQLiteDatabase db = mHelper.getWritableDatabase();
                    db.delete(InputContract.TaskEntry.TABLE,
                            InputContract.TaskEntry.COL_TASK_TITLE + " = ?",
                            new String[]{title_of_row_to_delete}); //<<<<<<<<
                    db.close();
                    updateUI();
                    itemsAdapter.notifyDataSetChanged();
                    // Return true consumes the long click event (marks it handled)
                    return true;
                }

            });
    }