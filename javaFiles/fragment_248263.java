Button deleteBtn = (Button) row.findViewById(R.id.buttonDelete);
deleteBtn.setTag(databaseProvider.getTeamNumber());
    deleteBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            deleteRow((String) v.getTag());
            list.remove(position);
            notifyDataSetChanged();
        }
    });