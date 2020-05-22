button.setOnLongClickListener(new View.OnLongClickListener() {
    public boolean onLongClick(View v) {
        ArrayList<Checklist> temp = new ArrayList<Checklist>();
        for (int i = 0; i < checklistItems.size(); i++){
            if (checklistItems.get(i).getValue() == 0)
                temp.add(checklistItems.get(i));
        }

        //checklistItems = temp; //Don't change reference of Adapter data source

        checklistItems.clear(); //added
        checklistItems.addAll(temp); //added

        myAdapter.notifyDataSetChanged();

        return true;
    }
});